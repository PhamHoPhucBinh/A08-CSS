package com.service;

import com.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int productId);
    List<Product> findAll();
}
