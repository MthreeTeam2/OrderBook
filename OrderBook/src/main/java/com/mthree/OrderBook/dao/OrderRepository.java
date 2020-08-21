/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import java.util.List;
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
    // Dont think we will need these
//    List<Order> findByStock(Stock stock);
//    List<Order> findByParty(Party party);
    
    // functionality of remaining methods can be accomplished by using lambdas and streams in the service layer 
    
    //List<Order> buyOrdersforStock = OrderRepository.findByStock.stream.filter((o)-> o.isBuy == true )
}
