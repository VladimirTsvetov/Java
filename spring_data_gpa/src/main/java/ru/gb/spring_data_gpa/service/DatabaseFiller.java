package ru.gb.spring_data_gpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.spring_data_gpa.model.Product;
import ru.gb.spring_data_gpa.repository.ProductRepository;

@Component
public class DatabaseFiller {
    @Autowired
    ProductRepository productRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApplication(){
        productRepository.save(createProduct("Sullivans Cove",3999L));
        productRepository.save(createProduct("Three Ships",5000L));
    }

    private Product createProduct(String title, Long price){
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        return product;

    }

}
