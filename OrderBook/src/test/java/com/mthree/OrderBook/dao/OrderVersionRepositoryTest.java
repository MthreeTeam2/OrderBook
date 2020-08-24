/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Order;
import com.mthree.OrderBook.entities.OrderVersion;
import com.mthree.OrderBook.entities.Party;
import com.mthree.OrderBook.entities.Stock;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Gethma Perera
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderVersionRepositoryTest {

    @Autowired
    AuditRepository auditRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    OrderVersionRepository orderVersionRepository;

    public OrderVersionRepositoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

        orderVersionRepository.deleteAll();
        orderRepository.deleteAll();
        partyRepository.deleteAll();
        stockRepository.deleteAll();
        tradeRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetOrderVersion() {
        Party party = new Party();
        party.setSymbol("ABC");
        party.setName("ABC Name");
        partyRepository.save(party);

        Stock stock = new Stock();
        stock.setSymbol("STK");
        stock.setOrdersToday(500);
        stock.setVolumeToday(100000);
        stock.setLatestMatch(new BigDecimal(1000.02).setScale(2, RoundingMode.HALF_UP));
        stock.setTickSize(new BigDecimal(0.5).setScale(2, RoundingMode.HALF_UP));
        stockRepository.save(stock);

        Order order = new Order();
        order.setParty(party);
        order.setStock(stock);
        order.setIsBuy(true);
        orderRepository.save(order);

        OrderVersion orderVersion = new OrderVersion();
        orderVersion.setOrder(order);
        orderVersion.setTime(LocalDateTime.now().withNano(0));
        orderVersion.setSize(100);
        orderVersion.setIsActive(true);
        orderVersion.setPrice(new BigDecimal(50.23).setScale(2, RoundingMode.HALF_UP));
        orderVersionRepository.save(orderVersion);

        List<OrderVersion> orderVersions = orderVersionRepository.findAll();
        System.out.println(orderVersion.toString());
        System.out.println(orderVersions.get(0).toString());
        assertEquals(orderVersions.size(), 1);
        assertTrue(orderVersions.contains(orderVersion));

    }

    @Test
    public void testFindByOrder() {
        Party party = new Party();
        party.setSymbol("ABC");
        party.setName("ABC Name");
        partyRepository.save(party);

        Party party2 = new Party();
        party2.setSymbol("DEF");
        party2.setName("DEF Name");
        partyRepository.save(party2);

        Stock stock = new Stock();
        stock.setSymbol("STK");
        stock.setOrdersToday(500);
        stock.setVolumeToday(100000);
        stock.setLatestMatch(new BigDecimal(1000.02).setScale(2, RoundingMode.HALF_UP));
        stock.setTickSize(new BigDecimal(0.5).setScale(2, RoundingMode.HALF_UP));
        stockRepository.save(stock);

        Order order = new Order();
        order.setParty(party);
        order.setStock(stock);
        order.setIsBuy(true);
        orderRepository.save(order);

        Order order2 = new Order();
        order2.setParty(party2);
        order2.setStock(stock);
        order2.setIsBuy(true);
        orderRepository.save(order2);

        OrderVersion orderVersion = new OrderVersion();
        orderVersion.setOrder(order);
        orderVersion.setTime(LocalDateTime.now().withNano(0));
        orderVersion.setSize(100);
        orderVersion.setIsActive(true);
        orderVersion.setPrice(new BigDecimal(50.23).setScale(2, RoundingMode.HALF_UP));
        orderVersionRepository.save(orderVersion);

        OrderVersion orderVersion2 = new OrderVersion();
        orderVersion2.setOrder(order);
        orderVersion2.setTime(LocalDateTime.now().withNano(0));
        orderVersion2.setSize(120);
        orderVersion2.setIsActive(true);
        orderVersion2.setPrice(new BigDecimal(50.55).setScale(2, RoundingMode.HALF_UP));
        orderVersionRepository.save(orderVersion2);

        OrderVersion orderVersion3 = new OrderVersion();
        orderVersion3.setOrder(order2);
        orderVersion3.setTime(LocalDateTime.now().withNano(0));
        orderVersion3.setSize(120);
        orderVersion3.setIsActive(true);
        orderVersion3.setPrice(new BigDecimal(50.45).setScale(2, RoundingMode.HALF_UP));
        orderVersionRepository.save(orderVersion2);

        List<OrderVersion> orderVersions = orderVersionRepository.findByOrder(order);

        assertEquals(orderVersions.size(), 2);
        assertTrue(orderVersions.contains(orderVersion));
        assertTrue(orderVersions.contains(orderVersion2));
        assertFalse(orderVersions.contains(orderVersion3));
    }

    @Test
    public void testFindByOrder_Stock() {
        Party party = new Party();
        party.setSymbol("ABC");
        party.setName("ABC Name");
        partyRepository.save(party);

        Stock stock = new Stock();
        stock.setSymbol("STK");
        stock.setOrdersToday(500);
        stock.setVolumeToday(100000);
        stock.setLatestMatch(new BigDecimal(1000.02).setScale(2, RoundingMode.HALF_UP));
        stock.setTickSize(new BigDecimal(0.5).setScale(2, RoundingMode.HALF_UP));
        stockRepository.save(stock);

        Stock stock2 = new Stock();
        stock2.setSymbol("LKR");
        stock2.setOrdersToday(600);
        stock2.setVolumeToday(200000);
        stock2.setLatestMatch(new BigDecimal(500.02).setScale(2, RoundingMode.HALF_UP));
        stock2.setTickSize(new BigDecimal(0.5).setScale(2, RoundingMode.HALF_UP));
        stockRepository.save(stock2);

        Order order = new Order();
        order.setParty(party);
        order.setStock(stock);
        order.setIsBuy(true);
        orderRepository.save(order);

        Order order2 = new Order();
        order2.setParty(party);
        order2.setStock(stock2);
        order2.setIsBuy(true);
        orderRepository.save(order2);

        OrderVersion orderVersion = new OrderVersion();
        orderVersion.setOrder(order);
        orderVersion.setTime(LocalDateTime.now().withNano(0));
        orderVersion.setSize(100);
        orderVersion.setIsActive(true);
        orderVersion.setPrice(new BigDecimal(50.23).setScale(2, RoundingMode.HALF_UP));
        orderVersionRepository.save(orderVersion);

        OrderVersion orderVersion2 = new OrderVersion();
        orderVersion2.setOrder(order2);
        orderVersion2.setTime(LocalDateTime.now().withNano(0));
        orderVersion2.setSize(120);
        orderVersion2.setIsActive(true);
        orderVersion2.setPrice(new BigDecimal(50.55).setScale(2, RoundingMode.HALF_UP));
        orderVersionRepository.save(orderVersion2);

        List<OrderVersion> orderVersions = orderVersionRepository.findByOrder_Stock(stock);

        assertEquals(orderVersions.size(), 1);
        assertTrue(orderVersions.contains(orderVersion));
        assertFalse(orderVersions.contains(orderVersion2));
    }

}
