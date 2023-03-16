package com.tsv.webshop.controllers;

import com.tsv.webshop.mappers.IdentityMapper;
import com.tsv.webshop.mappers.ProductMapper;
import com.tsv.webshop.dtos.ProductDto;
import com.tsv.webshop.entities.Product;
import com.tsv.webshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productConvertor;

    private final IdentityMapper identityMapper;
    @GetMapping
    public List<ProductDto> findAllProducts(){
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> productList = productService.findAll();

        //добавляем продукты в identitymapper и конвертируем в dto
        for(Product product:productList){
            identityMapper.setProductById(product.getId(),product);
            productDtoList.add(productConvertor.productToDto(product));
        }
        return productDtoList;
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id){
        //если продукт есть в мапе, то выдаем его
        if(identityMapper.getId(id))
            return productConvertor.productToDto(identityMapper.getProductById(id));
        else{
            //добавляем продукт в мапу, конвертируем в дто и выдаем дто
            Product product = productService.findById(id).orElseThrow();
            identityMapper.setProductById(id,product);
            return productConvertor.productToDto(product);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

}
