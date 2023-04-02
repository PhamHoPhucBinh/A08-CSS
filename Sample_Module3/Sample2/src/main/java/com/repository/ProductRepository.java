package com.repository;

import com.model.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(int productId);
    List<Product> findAll();
}
