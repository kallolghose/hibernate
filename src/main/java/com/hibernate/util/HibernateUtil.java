package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private HibernateUtil(){}

    /*static {
        try{
            Configuration configuration = new Configuration().configure("");
            sessionFactory = configuration.buildSessionFactory();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }*/

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null) {
            File file = new File(ClassLoader.getSystemClassLoader().getResource("hibernate.cfg.xml").getFile());
            Configuration configuration = new Configuration().configure(file);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
