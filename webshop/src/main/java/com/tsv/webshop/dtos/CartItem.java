package com.tsv.webshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;


    public static class Builder{
        private CartItem cartItem;
        public Builder(){
            cartItem = new CartItem();
        }
        public Builder withProductId(Long productId){
            cartItem.setProductId(productId);
            return this;
        }
        public Builder withProductTitle(String productTitle){
            cartItem.setProductTitle(productTitle);
            return this;
        }
        public Builder withQuantity(int quantity){
            cartItem.setQuantity(quantity);
            return this;
        }
        public Builder withPricePerProduct(int pricePerProduct){
            cartItem.setPricePerProduct(pricePerProduct);
            return this;
        }
        public Builder withPrice(int price){
            cartItem.setPrice(price);
            return this;
        }
        public CartItem build(){
            return cartItem;
        }

    }
}
