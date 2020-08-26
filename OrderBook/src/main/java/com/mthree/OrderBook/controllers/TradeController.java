/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.controllers;

import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import com.mthree.OrderBook.service.serviceLayer;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ben
 */
@Controller
public class TradeController {
    
    @Autowired
    serviceLayer service;
    
    Set<ConstraintViolation<Stock>> violations = new HashSet<>();
    
    @GetMapping("tradedetails")
    public String orderBook(int id, Model model){
//        String symbol = request.getParameter("symb");
//        System.out.println("Symbol Order"+ symbol);
//        Optional<Stock> stock = service.getStockBySymbol(symbol);
//        List<OrderVersion> buyOrders = service.getActiveOrderVersionsForStock(stock.get(), true);
//        List<OrderVersion> sellOrders = service.getActiveOrderVersionsForStock(stock.get(), false);
//        List<Trade> trades = service.getTradesForStock(stock.get());
//        model.addAttribute("stock",stock.get());
//        model.addAttribute("buyOrders",buyOrders);
//        model.addAttribute("sellOrders",sellOrders);
//        model.addAttribute("trades",trades);
//        
        return "tradedetails";        
    }
}
