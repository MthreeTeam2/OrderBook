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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ben
 */
public interface serviceLayer {
    
    //ORDERS
    public Optional<Order> getOrderById(int id);
    public void cancelOrder(Order order);
    
    // ORDER VERSIONS
    public List<OrderVersion> getActiveOrderVersionsForStock(Stock stock, boolean buy);
    public List<OrderVersion> getAllOrderVersionsForOrder(Order order);
    
    
    // TRADES
    public List<Trade> getTradesForOrder(Order order);
    public List<Trade> getTradesForDay(LocalDate day);
    public List<Trade> getTradesForDayAndStock(LocalDate day, Stock stock);
    public Optional<Trade> getTradeById(int id);
    
    //STOCKS
    public List<Stock> getAllStocks();
    public Optional<Stock> getStockBySymbol(String symbol);
    
    //PARTYS
    public List<Party> getAllPartys();
    
}
