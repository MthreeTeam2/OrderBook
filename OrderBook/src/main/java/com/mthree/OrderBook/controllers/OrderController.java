/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.controllers;

import com.mthree.OrderBook.dao.OrderRepository;
import com.mthree.OrderBook.dao.PartyRepository;
import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.service.serviceLayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ben
 */
@Controller
public class OrderController {
    
    @Autowired
    serviceLayer service;
    
    @Autowired
    PartyRepository partyRep;
    
    @Autowired
    OrderRepository orderRep;
    

    
//    Set<ConstraintViolation<OrderVersion>> oVviolations = new HashSet<>();
    
    @PostMapping("neworder")
    public String addOrder( HttpServletRequest request){
        String stockSymbol = request.getParameter("symb");
        String partySymbol = request.getParameter("parties");
        String buySell = request.getParameter("isBuy");
        Boolean isBuy = true;
        OrderVersion ov = new OrderVersion();
        Optional<Party> party = partyRep.findById(partySymbol);
        
        Optional<Stock> stock = service.getStockBySymbol(stockSymbol);
        
        
        if (buySell.equals("Sell")){
            isBuy = false;
        }
        
        Order order = new Order();
        order.setParty(party.get());
        order.setStock(stock.get());
        order.setIsBuy(isBuy);
        try {
            int size = Integer.parseInt(request.getParameter("size"));
            BigDecimal price = new BigDecimal(request.getParameter("ticker")).setScale(2, RoundingMode.HALF_UP);
            ov.setPrice(price);
            ov.setSize(size);
        } catch (NullPointerException nfe){
            
        }
        ov.setIsActive(true);
        ov.setTime(LocalDateTime.now());
        
        orderRep.save(order);
        ov.setOrder(order);
        
        service.addOrder(ov);
        System.out.println("Order:"+ov.toString());
        
        
        return "redirect:/orderbook?symb="+stockSymbol;
        
    }
    
}
