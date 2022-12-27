package ru.gb.spring_data_gpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_data_gpa.model.Product;
import ru.gb.spring_data_gpa.model.ProductDto;
import ru.gb.spring_data_gpa.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public ProductService() {
    }

    public Product findById(Long id) {

        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void insertProduct(Product product) {
        product.setId(null);
        productRepository.save(product);
    }

    public void changeProduct(Product product) {

        productRepository.save(product);

    }
}
