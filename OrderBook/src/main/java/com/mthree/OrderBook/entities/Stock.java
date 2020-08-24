/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.entities;

import java.math.BigDecimal;
import java.util.Objects;
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
    private String symbol;
    
    @Column(name = "orderstoday",nullable = false)
    private int ordersToday;
    
    @Column(name = "volumetoday",nullable = false)
    private int volumeToday;
    
    @Column(name = "latestmatch", nullable = false)
    private BigDecimal latestMatch;
    
    @Column(name = "ticksize",nullable = false)
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.symbol);
        hash = 89 * hash + this.ordersToday;
        hash = 89 * hash + this.volumeToday;
        hash = 89 * hash + Objects.hashCode(this.latestMatch);
        hash = 89 * hash + Objects.hashCode(this.tickSize);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stock other = (Stock) obj;
        if (this.ordersToday != other.ordersToday) {
            return false;
        }
        if (this.volumeToday != other.volumeToday) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.latestMatch, other.latestMatch)) {
            return false;
        }
        if (!Objects.equals(this.tickSize, other.tickSize)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stock{" + "symbol=" + symbol + ", ordersToday=" + ordersToday + ", volumeToday=" + volumeToday + ", latestMatch=" + latestMatch + ", tickSize=" + tickSize + '}';
    }
    
    
    
    
}
