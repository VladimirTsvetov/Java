package org.gb;

import org.gb.factories.SessionFactoryUtils;
import org.gb.intefaces.IProductDao;
import org.gb.product.Product;
import org.gb.productdao.ProductDao;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try{
            IProductDao productDao = new ProductDao(sessionFactoryUtils);
            productDao.save(new Product("Milk",9.88));
            System.out.println(productDao.findByName("Milk"));

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sessionFactoryUtils.shutdown();
        }


    }
}