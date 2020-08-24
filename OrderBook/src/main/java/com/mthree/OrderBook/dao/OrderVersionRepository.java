/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Stock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface OrderVersionRepository extends JpaRepository<OrderVersion, Integer>{
    //add additional methods
    /**
     *  + getLatestVersionForOrder(Order order) COME BACK TO THIS ONE
        + getLastestActiveVersionForOrder(Order order) COME BACK TO THIS ONE
        + getAllActiveOrderVersionsForStock(Stock stock, Bool Buy)
        + getAllVersionsForOrder(Order order)
     */
    
    List <OrderVersion> findByOrderOrderByIdDesc(Order order);
    
    @Query("Select ov FROM orderversion ov "
            + "JOIN orders o on ov.order = o.id "
            + "JOIN  Stock s on o.stock = s.id "
            + "WHERE stock = ?1 AND ov.isActive = true AND o.isBuy = true "
            + "ORDER BY ov.price DESC")
    List <OrderVersion> getActiveBuyOrderVersionsForStock(Stock stock);
    
    @Query("Select ov FROM orderversion ov "
            + "JOIN orders o on ov.order = o.id "
            + "JOIN  Stock s on o.stock = s.id "
            + "WHERE stock = ?1 AND ov.isActive = true AND o.isBuy = false "
            + "ORDER BY ov.price ASC")
    List <OrderVersion> getActiveSellOrderVersionsForStock(Stock stock);
    
     
    
    
    List <OrderVersion> findByOrder_StockOrderByPriceDesc(Stock stock);
    
    // functionality of remaining methods can be accomplished by using lambdas and streams in the service layer
    
}
