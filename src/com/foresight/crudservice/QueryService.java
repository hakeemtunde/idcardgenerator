/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.crudservice;

import com.foresight.entity.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hakeemtunde
 */
public class QueryService {
    
    private static EntityManager em;
    private static Query query;
    
    private QueryService() {
       
    }
    
    public static void setInstance(EntityManager manager) {
        em = manager;
    }
    
    public static void buildQuery(String q) {
        query = em.createQuery(q);
    } 
    
    public static List getResult() {
        return query.getResultList();
    }
    
}
