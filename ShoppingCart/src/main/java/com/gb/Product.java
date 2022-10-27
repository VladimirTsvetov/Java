package com.gb;

public class Product {
    private int id;
    private double cost;
    private String title;

    Product(int id, double cost, String title){
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
}
