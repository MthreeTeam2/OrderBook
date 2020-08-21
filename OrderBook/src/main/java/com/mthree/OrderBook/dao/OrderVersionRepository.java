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
    
    List <OrderVersion> findByOrder(Order order);
    List <OrderVersion> findByOrder_Stock(Stock stock);
    
    // functionality of remaining methods can be accomplished by using lambdas and streams in the service layer
    
}
