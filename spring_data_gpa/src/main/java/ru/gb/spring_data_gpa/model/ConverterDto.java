package ru.gb.spring_data_gpa.model;

import org.springframework.stereotype.Component;

@Component
public class ConverterDto {
    public Product dtoToProduct(ProductDto productDto){
        Product product = new Product();

        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        return product;
    }

    public ConverterDto() {
    }

    public ProductDto productToDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setTitle(product.getTitle());

        return productDto;

    }
}
