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
import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import java.util.List;
import java.util.stream.Collectors;
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
    
    
    // ORDERS // Dont think we will need these
//    public List<Order> getOrdersForStock(Stock stock, boolean buy){
//        return orderRepository.findByStock(stock).stream().filter((o) -> o.isIsBuy()== buy).collect(Collectors.toList());
//    }
//    
//    public List<Order> getOrdersForParty(Party party, boolean buy){
//         return orderRepository.findByParty(party).stream().filter((o) -> o.isIsBuy()== buy).collect(Collectors.toList());
//    }
    
    // ORDER VERSIONs
    @Override
    public List<OrderVersion> getActiveOrderVersionsForStock(Stock stock, boolean buy){
        return orderVersionRepository.findByOrder_Stock(stock).stream().filter((o) -> o.getOrder().isIsBuy() == buy && o.isIsActive() == true).collect(Collectors.toList());
    }
    
    @Override
    public List<OrderVersion> getAllOrderVersionsForOrder(Order order){
        return orderVersionRepository.findByOrder(order);
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
    
    
    
   
    
    
}
