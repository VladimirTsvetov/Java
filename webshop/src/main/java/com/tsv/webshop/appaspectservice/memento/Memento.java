package com.tsv.webshop.appaspectservice.memento;

import com.tsv.webshop.dtos.Cart;

public class Memento {
    private Cart cart;
    public void setState(Cart currentCurt){
        cart = new Cart();
        cart.setItems(currentCurt.getItems());
        cart.setTotalPrice(currentCurt.getTotalPrice());
    }
    public Cart getState(){
        return cart;
    }
}
