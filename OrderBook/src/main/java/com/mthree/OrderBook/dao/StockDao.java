/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface StockDao extends JpaRepository<Stock, String>{
    //no additional methods needed
}
