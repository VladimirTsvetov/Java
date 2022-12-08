package org.gb.dao;

import org.gb.entity.Customer;

import org.gb.factories.SessionFactoryUtils;
import org.gb.intefaces.ICustomerDao;
import org.hibernate.Session;

import java.util.List;

public class CustomerDao implements ICustomerDao {
    private SessionFactoryUtils factoryUtils;

    public CustomerDao(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }


    @Override
    public Customer findByID(int id) {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class,id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer findByFirstname(String firstName) {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session
                    .createQuery("select c from Customer where c.firstname =:firstName",Customer.class)
                    .setParameter("firstname",firstName)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer findByLastname(String lastName) {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session
                    .createQuery("select c from Customer where c.lastname =:lastName",Customer.class)
                    .setParameter("firstname",lastName)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }
}
