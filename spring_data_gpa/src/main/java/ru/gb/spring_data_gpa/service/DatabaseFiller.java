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
        productRepository.save(createProduct("Sullivan's Cove",3999L,"Sullivan Distiller"));
        productRepository.save(createProduct("Three Ships",5000L,"Three Ships Co.,Ltd"));
    }

    private Product createProduct(String title, Long price, String producer){
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setProducer(producer);
        return product;

    }

}
