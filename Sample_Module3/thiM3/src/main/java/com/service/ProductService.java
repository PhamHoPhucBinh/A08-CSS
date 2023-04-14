package com.service;

import com.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int productId);
    void add(Product product);
    boolean update(Product product);

    boolean soft_remove(int productId) throws SQLException;
    List<Product> findByProductName(String productName);
}
