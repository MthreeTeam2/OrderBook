/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    //need to add additional methods
    /**
     *  + getOrdersForStock(Stock stock)
        + getOrdersForParty(Party party)
        + getOrdersForStock(Stock stock, Bool buy)
        + getOrdersForParty(Party party, Bool buy)
     */
}
