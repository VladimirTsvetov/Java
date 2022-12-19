package ru.gb.spring_data_gpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_data_gpa.model.Product;
import ru.gb.spring_data_gpa.model.ProductDto;
import ru.gb.spring_data_gpa.repository.ProductRepository;
import ru.gb.spring_data_gpa.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductDto> getProducts(){
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PostMapping
    public void insertProduct(@RequestBody Product product){
        productService.insertProduct(product);
    }

    @PutMapping("/change")
    public void changeProduct(@RequestBody Product product){
        productService.changeProduct(product);
    }
}
