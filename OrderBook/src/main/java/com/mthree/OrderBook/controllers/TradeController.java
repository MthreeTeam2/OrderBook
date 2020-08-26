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
import java.time.format.DateTimeFormatter;
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
        Optional<Trade> trade = service.getTradeById(id);
        Stock stock = trade.get().getBuyOrderVersion().getOrder().getStock();
        OrderVersion buyOV=trade.get().getBuyOrderVersion();
        OrderVersion sellOV=trade.get().getSellOrderVersion();
        System.out.println(trade.toString());
        model.addAttribute("trade",trade.get());   
        model.addAttribute("stock",stock);
        model.addAttribute("buyOV",buyOV);
        model.addAttribute("sellOV",sellOV);
        model.addAttribute("date",trade.get().getTime().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("time",trade.get().getTime().format(DateTimeFormatter.ISO_TIME));
        return "tradedetails";        
    }
    
    @GetMapping("orderversionhistory1")
    public String orderversionDetails(Model model){
        return "orderversionhistory";
    }
}
