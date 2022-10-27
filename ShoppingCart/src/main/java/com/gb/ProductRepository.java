package com.gb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products= new ArrayList<>();
    //возвращаем весь список
    public List getList(){
        return products;
    }
    //возвращаем товар по id
    public Product getProduct(int id){
        for(Product product: products){
            if(id == product.getId())
                return product;
        }
        return null;  //лучше конечно возвращать объект-заглушку "пустой продукт...."
    }

    public ProductRepository() {
        products.add(new Product(1,5284.00,"Tomatin Legacy"));
        products.add(new Product(2,16296.00,"Dalmore 12 Years Old Sherry Cask Select"));
        products.add(new Product(3,6720.00,"Benriach The Smoky Ten"));
        products.add(new Product(4,18800.00,"Lagavulin 16 Years Old"));
        products.add(new Product(5,10552.00,"Glenmorangie A Tale of Winter"));
    }

}
