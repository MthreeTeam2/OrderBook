/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer>{
    //add additional methods
    /**
     *  + getTradesForOrder(Order order)
        + getTradeForOrderVersion(OrderVersion orderversion) COME BACK TO THIS ONE
        + getTenMostRecentTradesForStock(Stock stock)
        + getTenMostRecentTrades()
        + getTradesForDate()
        + getTradesForStockDate()   
     */
    List<Trade> findBybuyOrderVersion_Order(Order order);
    
    
    List<Trade> findBybuyOrderVersion(OrderVersion orderVersion);
    
    List<Trade> findBybuyOrderVersion_Order_Stock(Stock stock);
    
    List<Trade> findBysellOrderVersion_Order(Order order);

    List<Trade> findBysellOrderVersion(OrderVersion orderVersion);

    List<Trade> findBysellOrderVersion_Order_Stock(Stock stock);
    
    // functionality of remaining methods can be accomplished by using lambdas and streams in the service layer
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**@Query("SELECT t FROM Trade t WHERE t.date = ?1")
    List<Trade> findByDate(Date date);
    
    @Query("SELECT t FROM Trade t "
            + "INNER JOIN OrderVersion ov ON t.buyOrderVersion = ov.id"
            + "INNER JOIN Order o ON ov.order = o.id"
            + "INNER JOIN Stock s ON o.stock = s.id"
            + " WHERE t.time = ?1 AND s.id = ?2 ")
    List<Trade> findByDateAndStockId(Date date, int stockId);
    
    @Query("SELECT t FROM Trade t ORDER by date DESC LIMIT 10")
    List<Trade> getTenMostRecentTrades();
    
    @Query("SELECT t FROM Trade t "
            + "INNER JOIN OrderVersion ov ON t.buyOrderVersion = ov.id"
            + "INNER JOIN Order o ON ov.order = o.id"
            + "INNER JOIN Stock s ON o.stock = s.id"
            + "WHERE AND s.id = ?2 "
            + "ORDER by t.time DESC LIMIT 10")
    List<Trade> getTenMostRecentTradesForStock(Date date, int stockId);*/
    
    
}
