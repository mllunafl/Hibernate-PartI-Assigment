package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    private SessionFactory sessionFactory;

    public static void main(String[] args) {
	    Main main = new Main();
	    main.doIt();
    }

    private void doIt() {
        createSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Student> result = session.createQuery("select s from Student s").list();
        for (Student student : result){
            System.out.println(student);
        }

        System.out.println("          ");

        result = session.createQuery("select s from Student s WHERE id > 10").list();
        for (Student student : result){
            System.out.println("Id over 10 " + student);
        }

        result = session.createQuery("select s from Student s WHERE name = 'Abigail One'").list();
        for (Student student : result){
            System.out.println(student);
        }


        session.getTransaction().commit();
        session.close();
        endSession();
    }

    private void createSession() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("my.cfg.xml")
                .build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.out.println("#ERROR " + e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private void endSession() {
        sessionFactory.close();
    }

}
