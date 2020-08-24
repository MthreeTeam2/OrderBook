/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
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
    @JoinColumn(name = "buyorderversion", nullable = false )
    private OrderVersion buyOrderVersion;
    
    @ManyToOne
    @JoinColumn(name = "sellorderversion", nullable = false )
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.buyOrderVersion);
        hash = 11 * hash + Objects.hashCode(this.sellOrderVersion);
        hash = 11 * hash + Objects.hashCode(this.price);
        hash = 11 * hash + Objects.hashCode(this.time);
        hash = 11 * hash + this.size;
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
        final Trade other = (Trade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (!Objects.equals(this.buyOrderVersion, other.buyOrderVersion)) {
            return false;
        }
        if (!Objects.equals(this.sellOrderVersion, other.sellOrderVersion)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trade{" + "id=" + id + ", buyOrderVersion=" + buyOrderVersion + ", sellOrderVersion=" + sellOrderVersion + ", price=" + price + ", time=" + time + ", size=" + size + '}';
    }
    
    
    
}
