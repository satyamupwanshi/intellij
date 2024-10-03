package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    // Static block for initializing the SessionFactory once
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to get the current session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Method to shut down the SessionFactory
    public static void shutdown() {
        sessionFactory.close();
    }
}
