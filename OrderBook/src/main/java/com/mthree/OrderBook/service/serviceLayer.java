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
import java.math.BigDecimal;
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
    public void addOrder(OrderVersion orderVersion);
    
    // ORDER VERSIONS
    public List<OrderVersion> getActiveOrderVersionsForStock(Stock stock, boolean buy);
    public List<OrderVersion> getAllOrderVersionsForOrder(Order order);
    public String getStatusForOrderVersion(OrderVersion orderVersion);
    public void updateOrder(OrderVersion orderVersion);
    
    
    // TRADES
    public List<Trade> getTradesForOrder(Order order);
    public List<Trade> getTradesForDay(LocalDate day);
    public List<Trade> getTradesForDayAndStock(LocalDate day, Stock stock);
    public Optional<Trade> getTradeById(int id);
    public List<Trade> getTradesForStock(Stock stock);
    public List<Trade> getTradesForOrderVersion(OrderVersion orderVersion);
    
    //STOCKS
    public List<Stock> getAllStocks();
    public Optional<Stock> getStockBySymbol(String symbol);
    public int getNumTradesTodayForStock(Stock stock);
    public int getVolumeTradedTodayForStock(Stock stock);
    public BigDecimal getLatestMatchForStock(Stock stock);
    
    
    //PARTYS
    public List<Party> getAllPartys();
    public Optional<Party> getPartyBySymbol(String symbol);
    
}
