package com.example.product_2.repository;

import com.example.product_2.bean.Product;

import java.util.List;

public interface ProductRepository {
    void create(Product product);
    void delete(String id);
    void update(Product product);
    List<Product> findAll();
    Product findById(String id);
}
