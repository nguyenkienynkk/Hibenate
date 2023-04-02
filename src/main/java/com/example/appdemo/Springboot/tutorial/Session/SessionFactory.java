package com.example.appdemo.Springboot.tutorial.Session;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SessionFactory {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private SessionFactory() {
        super();
    }
    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
                .configure() // Load hibernate.cfg.xml from resource folder by default
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return (SessionFactory) metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void close() {
        getSessionFactory().close();
    }
}