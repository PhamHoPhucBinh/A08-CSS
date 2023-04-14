package com.repository;

import com.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int productId);

    void add(Product product);

    boolean update(Product product);


    boolean SoftDelete(int productId) throws SQLException;

    List<Product> findByProductName(String productName);
}
