/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Entity(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    
    @ManyToOne
    @JoinColumn(name = "buyOrderVersion", nullable = false )
    private OrderVersion buyOrderVersion;
    
    @ManyToOne
    @JoinColumn(name = "sellOrderVersion", nullable = false )
    private OrderVersion sellOrderVersion;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column(nullable = false)
    private LocalDateTime time;
    
    @Column(nullable = false)
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderVersion getBuyOrderVersion() {
        return buyOrderVersion;
    }

    public void setBuyOrderVersion(OrderVersion buyOrderVersion) {
        this.buyOrderVersion = buyOrderVersion;
    }

    public OrderVersion getSellOrderVersion() {
        return sellOrderVersion;
    }

    public void setSellOrderVersion(OrderVersion sellOrderVersion) {
        this.sellOrderVersion = sellOrderVersion;
    }

   

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
