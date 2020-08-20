/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ben
 */
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String symbol;
    
    @Column(nullable = false)
    private int ordersToday;
    
    @Column(nullable = false)
    private int volumeToday;
    
    @Column(nullable = false)
    private BigDecimal latestMatch;
    
    @Column(nullable = false)
    private BigDecimal tickSize;
    
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrdersToday() {
        return ordersToday;
    }

    public void setOrdersToday(int ordersToday) {
        this.ordersToday = ordersToday;
    }

    public int getVolumeToday() {
        return volumeToday;
    }

    public void setVolumeToday(int volumeToday) {
        this.volumeToday = volumeToday;
    }

    public BigDecimal getLatestMatch() {
        return latestMatch;
    }

    public void setLatestMatch(BigDecimal latestMatch) {
        this.latestMatch = latestMatch;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }
    
    
}
