/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.controllers;

import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import com.mthree.OrderBook.entities.Trade;
import com.mthree.OrderBook.service.serviceLayer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
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
public class HomeController {
    
    @Autowired
    serviceLayer service;
    
    Set<ConstraintViolation<Stock>> violations = new HashSet<>();
    
    @GetMapping("/")
    public String displayStock(HttpServletRequest request,Model model){
        List<Stock> stocks = service.getAllStocks();
        for(Stock s : stocks){
            s.setOrdersToday(service.getNumTradesTodayForStock(s));
            s.setLatestMatch(service.getLatestMatchForStock(s));
            s.setVolumeToday(service.getVolumeTradedTodayForStock(s));
        }
        model.addAttribute("stocks",stocks);
        
        List <Trade> trades = service.getTradesForDay(LocalDate.now().minusDays(1));
        model.addAttribute("trades", trades);
        model.addAttribute("date", LocalDate.now().minusDays(1));

       
        
        return "index";
    }
    
    @GetMapping("orderbook")
    public String orderBook(HttpServletRequest request, Model model){
        String symbol = request.getParameter("symb");
        System.out.println("Symbol Order"+ symbol);
        Optional<Stock> stock = service.getStockBySymbol(symbol);
        List<OrderVersion> buyOrders = service.getActiveOrderVersionsForStock(stock.get(), true);
        List<OrderVersion> sellOrders = service.getActiveOrderVersionsForStock(stock.get(), false);
        List<Trade> trades = service.getTradesForStock(stock.get());
        model.addAttribute("stock",stock.get());
        model.addAttribute("buyOrders",buyOrders);
        model.addAttribute("sellOrders",sellOrders);
        model.addAttribute("trades",trades);
        
        return "orderbook";
        
    }
    
    @GetMapping("neworder")
    public String addOrder(HttpServletRequest request, Model model){
        String symbol = request.getParameter("symb");
        
        Optional<Stock> s = service.getStockBySymbol(symbol);
        List<Party> parties = service.getAllPartys();
        
        model.addAttribute("stock",s.get());
        model.addAttribute("parties",parties);
                
        
        return "neworder";
    }
   
    
//    @PostMapping("getTrades")
//    public String displayTrades(HttpServletRequest request, Model model){
//        String symbol = request.getParameter("stocks");
//        System.out.println(symbol);
//        String date = request.getParameter("date");
//        System.out.println(date);
////        List<Trade> trades = service.getTradesForDayAndStock(, )
//        return "redirect:/index";
//    }
    
    
    
}
