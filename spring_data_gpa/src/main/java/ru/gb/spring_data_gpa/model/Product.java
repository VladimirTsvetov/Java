package ru.gb.spring_data_gpa.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

//import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Long price;

    @Column(name = "producer")
    private String producer;



}
