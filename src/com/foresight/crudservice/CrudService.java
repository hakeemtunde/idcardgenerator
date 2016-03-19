/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.crudservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author hakeemtunde
 */
public class CrudService {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("idcardgenPU");;
    private static final EntityManager em = emf.createEntityManager();
    private static EntityTransaction tx;
    
    private CrudService() {
       
    }
    
    public static EntityTransaction getTransaction() {
        tx = em.getTransaction();
	return tx;
    }
    
//    public static void beginTransaction() {
//        tx.begin();
//    }
    
    public static EntityManager getEntityManager() {
        return em;
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public static void commit() {
        tx.commit();
    }
    
    public static void closeEntityManager() {
        getEntityManager().close();
        getEntityManagerFactory().close();
    }
    
    public static void persist( Object t) {
        getTransaction().begin();
        em.persist(t);
        commit();
    }
    
}
