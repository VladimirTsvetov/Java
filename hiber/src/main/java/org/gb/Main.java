package org.gb;

import org.gb.factories.SessionFactoryUtils;
import org.gb.intefaces.ICustomerDao;
import org.gb.entity.Product;
import org.gb.dao.CustomerDao;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try{
            ICustomerDao customerDao = new CustomerDao(sessionFactoryUtils);
            System.out.println(customerDao.findAll());

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sessionFactoryUtils.shutdown();
        }


    }
}