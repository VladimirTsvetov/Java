package ru.gb.spring_data_gpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private Long price;

    public ProductDto() {
    }
    public ProductDto(Product product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
