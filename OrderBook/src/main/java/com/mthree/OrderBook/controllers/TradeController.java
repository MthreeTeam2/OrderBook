/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.controllers;

import com.mthree.OrderBook.service.serviceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ben
 */
@Controller
public class TradeController {
    
    @Autowired
    serviceLayer service;
    
}
