package org.gb.factories;
import javax.persistence.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class SessionFactoryUtils {
    private SessionFactory sessionFactory;
    public void init(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void shutdown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
