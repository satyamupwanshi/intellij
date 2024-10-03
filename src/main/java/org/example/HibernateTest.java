package org.example ;

import com.example.entities.Myentity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        // Load configuration and build session factory
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Create a new Student entity and save it
        Myentity Myentity = new Myentity() ;
        Myentity student = new Myentity();
        Myentity.setId(1);
        Myentity.setName("John Doe");

        session.save(student);

        // Commit transaction
        transaction.commit();

        // Close session
        session.close();

        System.out.println("Hibernate is working properly!");
    }
}
