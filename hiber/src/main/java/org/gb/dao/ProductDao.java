package org.gb.dao;

import org.gb.factories.SessionFactoryUtils;
import org.gb.intefaces.IProductDao;
import org.gb.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDao implements IProductDao {

    private SessionFactoryUtils factoryUtils;

    public ProductDao(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public Product findById(Integer id) {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void save(Product product) {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product findByName(String title){
        try(Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session
                    .createQuery("select p from Product where p.title =:title",Product.class)
                    .setParameter("title",title)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }
}
