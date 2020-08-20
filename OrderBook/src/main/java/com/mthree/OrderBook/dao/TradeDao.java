/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface TradeDao extends JpaRepository<Trade, Integer>{
    //add additional methods
    /**
     *  + getTradesForOrder(Order order)
        + getTradeForOrderVersion(OrderVersion orderversion)
        + getTenMostRecentTradesForStock(Stock stock)
        + getTenMostRecentTrades()
        + getTradesForDate()
        + getTradesForStockDate()   
     */
}
