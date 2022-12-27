package ru.gb.spring_data_gpa.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_data_gpa.cards.Card;
import ru.gb.spring_data_gpa.model.ConverterDto;
import ru.gb.spring_data_gpa.model.Product;
import ru.gb.spring_data_gpa.model.ProductDto;
import ru.gb.spring_data_gpa.repository.ProductRepository;
import ru.gb.spring_data_gpa.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ConverterDto converterDto;
    private final Card productCard;

    /*public ProductController(ProductService productService) {
        this.productService = productService;
    }*/

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        Product product = productService.findById(id);
        return converterDto.productToDto(product);
    }

    @GetMapping
    public List<ProductDto> getProducts(){
        List<Product> productList = productService.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product p: productList){
            productDtoList.add(converterDto.productToDto(p));        }
        return productDtoList.stream().toList();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PostMapping
    public void insertProduct(@RequestBody ProductDto productDto){
        Product product = converterDto.dtoToProduct(productDto);
        productService.insertProduct(product);
    }

    @PutMapping("/change")
    public void changeProduct(@RequestBody ProductDto productDto){
        Product product = converterDto.dtoToProduct(productDto);
        productService.changeProduct(product);
    }

    @PostMapping("/card/add")
    public void addProductIntoCard(@RequestBody ProductDto productDto){
        productCard.addToCard(productDto);

    }

    @GetMapping("/users/")
    public List<String> getUsers(){
        List<String> userList = new ArrayList<>();
        userList.add("User1");
        userList.add("User2");
        userList.add("User3");
        return userList;
    }

    @GetMapping("/card")
    public List<ProductDto> fillCard(){
        return productCard.getProductDtoList();
    }
}
