package org.gb.intefaces;

import org.gb.product.Product;

import java.util.List;

public interface IProductDao {
    Product findById(Integer id);
    Product findByName(String name);
    List<Product> findAll();
    void save(Product product);
    void delete(Integer id);

}
