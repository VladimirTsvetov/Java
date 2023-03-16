package com.tsv.webshop.controllers;

import com.tsv.webshop.appaspectservice.memento.CareTaker;
import com.tsv.webshop.dtos.Cart;
import com.tsv.webshop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")

public class CartController {
    private final CartService cartService;
    private CareTaker careTaker;
    //сохраняем содержимое корзины
    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){

        cartService.add(id);
        //запоминаем текущее состояние корзины
        careTaker.setMemento(cartService.getCurrentCart().createMemento());
    }

    @GetMapping("/")
    public Cart getCurrentCart(){
        return cartService.getCurrentCart();
    }

    @GetMapping("/delete/{id}")
    public void deleteCartItem(@PathVariable Long id){

        cartService.deleteById(id);
        //запоминаем текущее состояние корзины
        careTaker.setMemento(cartService.getCurrentCart().createMemento());
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id){

        cartService.removeById(id);
        //запоминаем текущее состояние корзины
        careTaker.setMemento(cartService.getCurrentCart().createMemento());
    }

    @GetMapping("/clear")
    public void clear(){
        cartService.clear();
    }
}
