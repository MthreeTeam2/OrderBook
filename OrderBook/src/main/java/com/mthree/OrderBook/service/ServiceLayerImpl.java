/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.service;

import com.mthree.OrderBook.dao.AuditRepository;
import com.mthree.OrderBook.dao.OrderRepository;
import com.mthree.OrderBook.dao.OrderVersionRepository;
import com.mthree.OrderBook.dao.PartyRepository;
import com.mthree.OrderBook.dao.StockRepository;
import com.mthree.OrderBook.dao.TradeRepository;
import com.mthree.OrderBook.entities.Audit;
import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ben
 */
@Service
public class ServiceLayerImpl implements serviceLayer{
    
    @Autowired
    AuditRepository auditRepository;
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    PartyRepository partyRepository;
    
    @Autowired
    StockRepository stockRepository;
    
    @Autowired
    TradeRepository tradeRepository;
    
    @Autowired
    OrderVersionRepository orderVersionRepository;
    
    // ORDERS
    public Optional<Order> getOrderById(int id){
        return orderRepository.findById(id);
    }
    
    @Override
    @Transactional
    public void cancelOrder(Order order){
        OrderVersion latest = orderVersionRepository.findByOrderOrderByIdDesc(order).get(0);
        latest.setIsActive(false);
        orderVersionRepository.save(latest);
        String buyString;
        if(order.isIsBuy()== true){
            buyString = " BUY ";
        }
        else{
            buyString = " SELL ";
        }
            
        writeAudit("ORDER " + order.getId() + ": " + order.getParty().getSymbol() + buyString + order.getStock().getSymbol() + " CANCELLED.");
    }
    
    @Override
    @Transactional
    public void addOrder(OrderVersion orderVersion){

        // Add the order to the database and orderVersion to the Database
        Order order = orderVersion.getOrder();
        orderRepository.save(order);
        String buyString;
        if(order.isIsBuy()== true){
            buyString = " BUY ";
        }
        else{
            buyString = " SELL ";
        }
            
        writeAudit("ORDER " + order.getId() + ": " + order.getParty().getSymbol() + buyString + order.getStock().getSymbol() + " CREATED.");
        
        // Add and trade with the new  order version
        // potentially creates new buy orderversion, sell orderversions, and trades
        if(orderVersion.getOrder().isIsBuy()== true){
            addBuyOrderVersion(orderVersion);
        }else{
            addSellOrderVersion(orderVersion);
        }
 
    }
    
    @Override
    @Transactional
    public void updateOrder(OrderVersion orderVersion){
        Order order = orderVersion.getOrder();
        String buyString;
        if(order.isIsBuy()== true){
            buyString = " BUY ";
        }
        else{
            buyString = " SELL ";
        }
            
        writeAudit("ORDER " + order.getId() + ": " + order.getParty().getSymbol() + buyString + order.getStock().getSymbol() + " UPDATED.");
        
        // Add and trade with the new  order version
        // potentially creates new buy orderversion, sell orderversions, and trades
        if(orderVersion.getOrder().isIsBuy()== true){
            addBuyOrderVersion(orderVersion);
        }else{
            addSellOrderVersion(orderVersion);
        }
    }
    
    @Transactional
    private void addBuyOrderVersion(OrderVersion buyOrderVersion){
        // create variable which determines whether to keep trading 
        boolean trading = true;
        
        while(trading){
            // Add entry to database and assign complete fields to object from db 
            // so that entry is updated on next save (existing fully formed object with id)
            buyOrderVersion = orderVersionRepository.save(buyOrderVersion);
            
            
            if(orderVersionRepository.getActiveSellOrderVersionsForStock(buyOrderVersion.getOrder().getStock()).size()>0){
                // Get the cheapest active sell order version, sell order version will be updated on next save (existing fully formed object with id)
                OrderVersion sellOrderVersion = orderVersionRepository.getActiveSellOrderVersionsForStock(buyOrderVersion.getOrder().getStock()).get(0);

                // Check if the price of the sell order version is lower than or equal to the price of the buy order version
                // If so: do trading logic
                // If not: set trading to false
                if (sellOrderVersion.getPrice().compareTo(buyOrderVersion.getPrice()) == -1 || sellOrderVersion.getPrice().compareTo(buyOrderVersion.getPrice()) == 0) {

                    // Change the order versions to inactive and update entries
                    sellOrderVersion.setIsActive(false);
                    orderVersionRepository.save(sellOrderVersion);
                    buyOrderVersion.setIsActive(false);
                    orderVersionRepository.save(buyOrderVersion);

                    //  Calculates trade values, makes and obect and saves an entry to tb
                    createAndAddTrade(buyOrderVersion, sellOrderVersion, true);

                    // create and save new buy order version if there is remaining size, if there is no remaining size set go again to false
                    if (buyOrderVersion.getSize() > sellOrderVersion.getSize()) {
                        OrderVersion newBuyOrderVersion = makeNewOrderVersion(buyOrderVersion, sellOrderVersion.getSize());

                        // set buyOrderVersion to newBuyOrderVersion (without id) so that a new entry is created on next save at top of while loop
                        buyOrderVersion = newBuyOrderVersion;

                    } else {
                        trading = false;
                    }
                    // create and save new sell order version if there is remaining size
                    if (sellOrderVersion.getSize() > buyOrderVersion.getSize()) {
                        OrderVersion newSellOrderVersion = makeNewOrderVersion(sellOrderVersion, buyOrderVersion.getSize());

                        // save new sell order (without id), new entry created
                        orderVersionRepository.save(newSellOrderVersion);
                    }
                } else {
                    trading = false;
                }
                
                
            }else{
                trading = false;
            }
            
            
        }
    }
    
    @Transactional
    private void addSellOrderVersion(OrderVersion sellOrderVersion){
        boolean trading = true;
        
        while(trading){
            // Add entry to database and assign complete fields to object from db 
            // so that entry is updated on next save (existing fully formed object with id)
            sellOrderVersion = orderVersionRepository.save(sellOrderVersion);
            if(orderVersionRepository.getActiveBuyOrderVersionsForStock(sellOrderVersion.getOrder().getStock()).size()>0){
                
                // Get the highest active buy order version, buy order version will be updated on next save (existing fully formed object with id)
                OrderVersion buyOrderVersion = orderVersionRepository.getActiveBuyOrderVersionsForStock(sellOrderVersion.getOrder().getStock()).get(0);

                // Check if the price of the sell order version is lower than or equal to the price of the buy order version
                // If so: do trading logic
                // If not: set trading to false
                if (sellOrderVersion.getPrice().compareTo(buyOrderVersion.getPrice()) == -1 || sellOrderVersion.getPrice().compareTo(buyOrderVersion.getPrice()) == 0) {

                    // Change the order versions to inactive and update entries
                    sellOrderVersion.setIsActive(false);
                    orderVersionRepository.save(sellOrderVersion);
                    buyOrderVersion.setIsActive(false);
                    orderVersionRepository.save(buyOrderVersion);

                    //  Calculates trade values, makes and obect and saves an entry to tb
                    createAndAddTrade(buyOrderVersion, sellOrderVersion, false);

                    // create and save new sell order version if there is remaining size, if there is no remaining size set go again to false
                    if (buyOrderVersion.getSize() < sellOrderVersion.getSize()) {
                        OrderVersion newSellOrderVersion = makeNewOrderVersion(sellOrderVersion, buyOrderVersion.getSize());

                        // set buyOrderVersion to newBuyOrderVersion (without id) so that a new entry is created on next save at top of while loop
                        sellOrderVersion = newSellOrderVersion;

                    } else {
                        trading = false;
                    }

                    // create and save new sell order version if there is remaining size
                    if (sellOrderVersion.getSize() < buyOrderVersion.getSize()) {
                        OrderVersion newBuyOrderVersion = makeNewOrderVersion(buyOrderVersion, sellOrderVersion.getSize());

                        // save new sell order (without id), new entry created
                        orderVersionRepository.save(newBuyOrderVersion);
                    }

                } else {
                    trading = false;
                }
                
            }else{
                trading = false;
            }
            

        }
        
    }
    
    @Transactional
    private void createAndAddTrade(OrderVersion buyOrderVersion, OrderVersion sellOrderVersion, boolean buy){
        // The price of the trade will be executed at the price of the sell order version
        BigDecimal tradePrice;

        if(buy == true){
            // The price of the trade will be executed at the price of the sell order version
            tradePrice = sellOrderVersion.getPrice();
        }
        else{
            // The price of the trade will be executed at the price of the buy order version
            tradePrice = buyOrderVersion.getPrice();
        }
        
        
        // The size of the trade will be the minimum size of the buy and sell order versions
        int tradeSize = Math.min(sellOrderVersion.getSize(), buyOrderVersion.getSize());
        
        

        // Create and add the trade
        Trade trade = new Trade();
        trade.setBuyOrderVersion(buyOrderVersion);
        trade.setSellOrderVersion(sellOrderVersion);
        trade.setPrice(tradePrice);
        trade.setSize(tradeSize);
        trade.setTime(LocalDateTime.now());
        trade = tradeRepository.save(trade);
        
        writeAudit("TRADE " + trade.getId() + " BUY ORDER VERSION: " + buyOrderVersion.getId() + " SELL ORDER VERSION: " + sellOrderVersion.getId() + " PRICE: " + tradePrice + " SIZE: " + tradeSize);
    }
    
    private OrderVersion makeNewOrderVersion(OrderVersion old, int tradeSize){
        OrderVersion newOne = new OrderVersion();
        newOne.setIsActive(true);
        newOne.setOrder(old.getOrder());
        newOne.setPrice(old.getPrice());
        newOne.setTime(LocalDateTime.now());
        newOne.setSize(old.getSize() - tradeSize);
        return newOne;
        
    }
    
    // ORDER VERSIONs
    @Override
    public List<OrderVersion> getActiveOrderVersionsForStock(Stock stock, boolean buy){
        if(buy == true){
            return orderVersionRepository.getActiveBuyOrderVersionsForStock(stock);
        }else{
            return orderVersionRepository.getActiveSellOrderVersionsForStock(stock);
        }
    }
    
    
    @Override
    public List<OrderVersion> getAllOrderVersionsForOrder(Order order){
        return orderVersionRepository.findByOrderOrderByIdDesc(order);
    }
    
//    public String getStatusForOrderVersion(OrderVersion orderVersion){
//        if(orderVersion.isIsActive()==true){
//            return "Active";
//        }else{
//            if(tradeRepository.)
//        }
//    }
    
    
    // TRADES
    @Override
    public List<Trade> getTradesForOrder(Order order){
        if(order.isIsBuy() == true){
            return tradeRepository.findBybuyOrderVersion_Order(order);
        }else{
            return tradeRepository.findBysellOrderVersion_Order(order);
        }
    }
    
    @Override
    public List<Trade> getTradesForDay(LocalDate day){
        LocalDate dayPlusOne = day.plusDays(1);
        return tradeRepository.getTradesBetweenTimes(day.atStartOfDay(), dayPlusOne.atStartOfDay());
    }
    
    @Override
    public List<Trade> getTradesForDayAndStock(LocalDate day, Stock stock){
        LocalDate dayPlusOne = day.plusDays(1);
        return tradeRepository.getTradesBetweenTimesForStock(stock, day.atStartOfDay(), dayPlusOne.atStartOfDay());
    }
    
    @Override
    public Optional<Trade> getTradeById(int id){
        return tradeRepository.findById(id);
    }
    
     @Override
    public List<Trade> getTradesForStock(Stock stock) {
        return tradeRepository.getTradesForStock(stock).subList(0, 10);
    }
    
    // STOCKS
    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }
    
    @Override
    public Optional<Stock> getStockBySymbol(String symbol){
        return stockRepository.findById(symbol);
    }
    
    @Override
    public int getNumTradesTodayForStock(Stock stock){
         return getTradesForDayAndStock(LocalDate.now(), stock).size();
    }
    
    @Override
    public int getVolumeTradedTodayForStock(Stock stock){
        return getTradesForDayAndStock(LocalDate.now(), stock).stream().mapToInt(t -> t.getSize()).sum();
    }
    
    @Override
    public BigDecimal getLatestMatchForStock(Stock stock){
        Optional<Trade> trade = tradeRepository.getLatestTradeForStock(stock);
        if(trade.isPresent()){
            return trade.get().getPrice();
        }else{
            return null;
        }
    }
     
    
    // PARTYS
    @Override 
    public List<Party> getAllPartys(){
        return partyRepository.findAll();
    }
    
    @Override
    public Optional<Party> getPartyBySymbol(String symbol){
        return partyRepository.findById(symbol);
    }
    
    // AUDIT
    private void writeAudit(String message){
        Audit audit = new Audit();
        audit.setMessage(message);
        audit.setTime(LocalDateTime.now());
        auditRepository.save(audit);
    }

   
    
    
     
    
    
    
   
    
    
}
