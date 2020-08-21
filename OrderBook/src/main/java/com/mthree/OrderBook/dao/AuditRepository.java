/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.OrderBook.dao;

import com.mthree.OrderBook.entities.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer>{
    // don't think this needs more methods, as addAudit should be fine
    // service layer should then maybe include method that converts an action to an audit friendly message
}
