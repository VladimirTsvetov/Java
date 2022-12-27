package ru.gb.spring_data_gpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_data_gpa.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
