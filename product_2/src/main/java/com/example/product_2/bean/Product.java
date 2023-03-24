package com.example.product_2.bean;

public class Product {
    String  id ;
    String name ;
    float price ;
    String status ;

    public Product(String id, String name, float price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}