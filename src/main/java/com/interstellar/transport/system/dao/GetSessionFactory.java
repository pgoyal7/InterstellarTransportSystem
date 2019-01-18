package com.interstellar.transport.system.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * Get the singleton object of the sessionfactory
 * 
 * */
public class GetSessionFactory 
{ 
    // static variable SESION_FACTOR_INSTANCE of type Singleton 
    private static GetSessionFactory SESION_FACTOR_INSTANCE = null; 
  
    // variable of type SessionFactory 
    public SessionFactory sessionFactory; 
  
    // private constructor restricted to this class itself 
    private GetSessionFactory() 
    { 
    	sessionFactory = getSessionFactoryObject();
    } 
  
    // static method to create instance of GetSessionFactory class 
    public static GetSessionFactory getInstance() 
    { 
        if (SESION_FACTOR_INSTANCE == null) 
            SESION_FACTOR_INSTANCE = new GetSessionFactory(); 
  
        return SESION_FACTOR_INSTANCE; 
    } 
    
    /*
	 * Factory method to get the singleton object
	 * 
	 * */
    private static SessionFactory getSessionFactoryObject() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}
} 