package com.example.product_2.service;

import com.example.product_2.bean.Product;

import java.util.List;

public interface ProductService  {
    void create(Product product);
    void delete(String id);
    void update(Product product);
    List<Product> findAll();
    Product findById(String id);
}
