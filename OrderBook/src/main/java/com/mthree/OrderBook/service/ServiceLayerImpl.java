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
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Optional;
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
    
    public void addBuyOrder(Order order, OrderVersion buyOrderVersion){
        
        // create variable which determine whether to keep trading 
        boolean trading = true;
        
        // Add the order to the database and orderVersion to the Database
        orderRepository.save(order);
        
        
        while(trading){
            // Add order version to database and assign complete object fields from db to buyOrderVersion
            buyOrderVersion = orderVersionRepository.save(buyOrderVersion);
            
            // Get the cheapest active sell order version
            OrderVersion sellOrderVersion = orderVersionRepository.getActiveSellOrderVersionsForStock(order.getStock()).get(0);

            // Check if the price of the sell order version is lower than or equal to the price of the buy order version
            // If so: do trading logic
            // If not: set trading to false
            if (sellOrderVersion.getPrice().compareTo(buyOrderVersion.getPrice()) == -1 || sellOrderVersion.getPrice().compareTo(buyOrderVersion.getPrice()) == 0) {

                // The price of the trade will be executed at the price of the sell order version
                BigDecimal tradePrice = sellOrderVersion.getPrice();

                // The size of the trade will be the minimum size of the buy and sell order versions
                int tradeSize = Math.min(sellOrderVersion.getSize(), buyOrderVersion.getSize());

                // Change the order versions to inactive and update them
                sellOrderVersion.setIsActive(false);
                orderVersionRepository.save(sellOrderVersion);
                buyOrderVersion.setIsActive(false);
                orderVersionRepository.save(buyOrderVersion);

                // Create and add the trade
                Trade trade = new Trade();
                trade.setBuyOrderVersion(buyOrderVersion);
                trade.setSellOrderVersion(sellOrderVersion);
                trade.setPrice(tradePrice);
                trade.setSize(tradeSize);
                trade.setTime(LocalDateTime.now());
                tradeRepository.save(trade);

                // create and save new buy order version if there is remaining size, if there is no remaining size set go again to false
                if (buyOrderVersion.getSize() > tradeSize) {
                    OrderVersion newBuyOrderVersion = copyOrderVersion(buyOrderVersion, tradeSize);
                    
                    // set buy order version to the fully formed newBuyOrderVersion (with sql auto generated id) for the next performance of the while loop
                    // and also add new buy order version
                    buyOrderVersion = newBuyOrderVersion;

                } else {
                    trading = false;
                }

                // create and save new sell order version if there is remaining size
                if (sellOrderVersion.getSize() >tradeSize ) {
                    OrderVersion newSellOrderVersion = copyOrderVersion(sellOrderVersion, tradeSize);
                   
                    // set buy order version to the fully formed newBuyOrderVersion (with sql auto generated id) for the next performance of the while loop
                    orderVersionRepository.save(newSellOrderVersion);

                }

            } else {
                trading = false;
            }
        }
           
    }
    
    private OrderVersion copyOrderVersion(OrderVersion old, int tradeSize){
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
    
    // STOCKS
    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }
    
    @Override
    public Optional<Stock> getStockBySymbol(String symbol){
        return stockRepository.findById(symbol);
    }
     
    
    // PARTYS
    @Override 
    public List<Party> getAllPartys(){
        return partyRepository.findAll();
    }
    
    // AUDIT
    private void writeAudit(String message){
        Audit audit = new Audit();
        audit.setMessage(message);
        audit.setTime(LocalDateTime.now());
        auditRepository.save(audit);
    }
    
    
     
    
    
    
   
    
    
}
