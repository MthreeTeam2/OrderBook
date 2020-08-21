/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
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
     *  + getLatestVersionForOrder(Order order)
        + getLastestActiveVersionForOrder(Order order)
        + getAllActiveOrderVersionsForStock(Stock stock, Bool Buy)
        + getAllVersionsForOrder(Order order)
     */
    
}
