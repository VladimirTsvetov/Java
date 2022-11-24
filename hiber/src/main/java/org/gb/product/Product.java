package org.gb.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name = "price")
    private Double price;

    public Product(){}  //это требование гибернэйта, как нам доктор говорил )

    public Product(String title, Double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product id = " + id.toString() + " title = " + title + " price = " + price.toString();
    }

}
