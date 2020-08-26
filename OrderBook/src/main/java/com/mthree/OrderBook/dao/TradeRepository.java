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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    List<Trade> findBysellOrderVersion_Order(Order order);
    List<Trade> findBybuyOrderVersion(OrderVersion orderVersion);
    List<Trade> findBysellOrderVersion(OrderVersion orderVersion);
     
    @Query("SELECT t FROM trades t "
            + "WHERE t.time > ?1 AND time < ?2 "
            + "ORDER BY t.time DESC ")
    List<Trade> getTradesBetweenTimes(LocalDateTime time1, LocalDateTime time2);
    
    @Query("SELECT t FROM trades t "
               + "JOIN orderversion ov on t.buyOrderVersion = ov.id "
                + "JOIN orders o on ov.order = o.id "
                + "JOIN  Stock s on o.stock = s.id "
               + "WHERE s = ?1 AND t.time > ?2 AND time < ?3 "
                + "ORDER BY t.time DESC ")
    List<Trade> getTradesBetweenTimesForStock(Stock stock, LocalDateTime time, LocalDateTime time2);
    @Query("SELECT t FROM trades t "
            + "JOIN orderversion ov on t.buyOrderVersion=ov.id "
            + "JOIN orders o on ov.order = o.id "
            + "JOIN Stock s on o.stock = s.id "
            + "WHERE s = ?1 "
            + "ORDER by t.time DESC")
    List<Trade> getTradesForStock(Stock stock);
    
    
    
    
     @Query("SELECT t FROM trades t "
            + "JOIN orderversion ov on t.buyOrderVersion=ov.id "
            + "JOIN orders o on ov.order = o.id "
            + "JOIN Stock s on o.stock = s.id "
            + "WHERE s = ?1 AND t.id = (SELECT MAX(id) FROM trades)" )
    Optional<Trade> getLatestTradeForStock(Stock stock);
            
    
    
    
}
