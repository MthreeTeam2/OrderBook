/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.service;

import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import java.util.List;

/**
 *
 * @author ben
 */
public interface serviceLayer {
    
    // Dont think we will need these
//    public List<Order> getOrdersForStock(Stock stock, boolean buy);
//    public List<Order> getOrdersForParty(Party party, boolean buy);
    public List<OrderVersion> getActiveOrderVersionsForStock(Stock stock, boolean buy);
    public List<OrderVersion> getAllOrderVersionsForOrder(Order order);
    public List<Trade> getTradesForOrder(Order order);
}
