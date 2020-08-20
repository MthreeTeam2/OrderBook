/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ben
 */
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "party", nullable = false)
    private Party party;
    
    @ManyToOne
    @JoinColumn(name = "stock", nullable = false)
    private Stock stock;
    
    @Column(name = "buy",nullable = false)
    private boolean isBuy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public boolean isIsBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }
    
    
    
}
