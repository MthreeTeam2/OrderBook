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
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        return tradeRepository.getTradesBetweenTimes(day.atStartOfDay(), day.atTime(24, 0));
    }
    
    @Override
    public List<Trade> getTradesForDayAndStock(LocalDate day, Stock stock){
        return tradeRepository.getTradesBetweenTimesForStock(stock, day.atStartOfDay(), day.atTime(24, 0));
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
