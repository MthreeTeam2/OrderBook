/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.service;

import com.mthree.OrderBook.dao.AuditDao;
import com.mthree.OrderBook.dao.OrderDao;
import com.mthree.OrderBook.dao.OrderVersionDao;
import com.mthree.OrderBook.dao.PartyDao;
import com.mthree.OrderBook.dao.StockDao;
import com.mthree.OrderBook.dao.TradeDao;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

/**
 *
 * @author ben
 */
@Service
public class ServiceLayerImpl implements serviceLayer{
    
    @Autowired
    AuditDao auditRepository;
    
    @Autowired
    OrderDao orderRepository;
    
    @Autowired
    PartyDao partyRepository;
    
    @Autowired
    StockDao stockRepository;
    
    @Autowired
    TradeDao tradeRepository;
    
    @Autowired
    OrderVersionDao orderVersionRepository;
    
    
    
    Trade getTrade(int id){
        Trade trade = tradeReposistory.
    }
    
    
}
