package br.com.bfood.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory BFOOD = Persistence.createEntityManagerFactory("bfood");

    public static EntityManager getEntityManagerBFood(){
        return BFOOD.createEntityManager();
    }
}
