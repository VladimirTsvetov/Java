package com.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> productList = new ArrayList<>();
    private ProductRepository productRepository;
    @Autowired
    Cart(ProductRepository rep){
        productRepository = rep;
    }
    public void addById(int id){
        Product product = productRepository.getProduct(id);
        if( product!= null)
            productList.add(product);
    }
    public void delById(int id){
        Product product = productRepository.getProduct(id);
        if( product != null)
            productList.remove(product.getId());
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(productList.isEmpty())
            return "Корзина пуста!";
        for(Product p: productList){
            sb.append(p.getId() + " " + p.getTitle() + " " + p.getCost() + " руб. " + "\n");
        }
        return sb.toString();
    }

}
