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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ben
 */
@Controller
public class OrderController {
    
    @Autowired
    serviceLayer service;
    
//    Set<ConstraintViolation<OrderVersion>> oVviolations = new HashSet<>();
    
    @PostMapping("neworder")
    public String addOrder( HttpServletRequest request){
        String stockSymbol = request.getParameter("symb");
        String partySymbol = request.getParameter("parties");
        String buySell = request.getParameter("isBuy");
        Boolean isBuy = true;
        OrderVersion ov = new OrderVersion();
        Optional<Party> party = service.getPartyBySymbol(partySymbol);
        
        
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
        

        ov.setOrder(order);
        
        service.addOrder(ov);
        
        
        
        return "redirect:/orderbook?symb="+stockSymbol;
        
    }

    
    @GetMapping("orderversionhistory")
    public String orderversionDetails(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("orderId"));
        System.out.println(id);
        
        Optional<Order> order = service.getOrderById(id);
        System.out.println(order);
        model.addAttribute("order",order.get());
        Boolean isBuy = order.get().isIsBuy();
        if (isBuy == true){
            model.addAttribute("buySell","BUY");
        }
        else if (isBuy == false){
            model.addAttribute("buySell","SELL");
        }
        
        List<OrderVersion> ovList = service.getAllOrderVersionsForOrder(order.get());
        
        for(OrderVersion o : ovList ){
            o.setStatus(service.getStatusForOrderVersion(o));
        }
        boolean active = ovList.get(0).isIsActive();
        
        model.addAttribute("active", active);
        
        model.addAttribute("orderVersions",ovList);
        return "orderversionhistory";
    }
    
    @GetMapping("amendorder")
    public String amendOrder(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("orderid"));
        Optional<Order> order = service.getOrderById(id);
        
        model.addAttribute("order",order.get());
        Boolean isBuy = order.get().isIsBuy();
        if (isBuy == true){
            model.addAttribute("buySell","BUY");
        }
        else if (isBuy == false){
            model.addAttribute("buySell","SELL");
        }
        List<Party> parties = service.getAllPartys();
        model.addAttribute("parties",parties);
        return "amendorder";
    }
    
    @PostMapping("amendorder")
    public String performAmendOrder(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("orderid"));
        Optional<Order> order = service.getOrderById(id);
        String symbol = request.getParameter("parties");
       
        
        OrderVersion ov = new OrderVersion();
        
        
       
        
        
        try {
            int size = Integer.parseInt(request.getParameter("size"));
            BigDecimal price = new BigDecimal(request.getParameter("ticker")).setScale(2, RoundingMode.HALF_UP);
            ov.setPrice(price);
            ov.setSize(size);
        } catch (NullPointerException nfe){
            
        }
        ov.setOrder(order.get());
        ov.setTime(LocalDateTime.now());
        ov.setIsActive(true);
        service.updateOrder(ov);
        String stockSymbol = order.get().getStock().getSymbol();
        return "redirect:/orderbook?symb="+stockSymbol;
    }
    
    
    
}
