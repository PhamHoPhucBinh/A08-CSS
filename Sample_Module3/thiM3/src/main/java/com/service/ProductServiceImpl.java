package com.service;

import com.model.Product;
import com.repository.ProductRepository;
import com.repository.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int productId) {
        return repository.findById(productId);
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public boolean update(Product product) {
        return repository.update(product);
    }

    @Override
    public boolean soft_remove(int productId) throws SQLException {
        return repository.SoftDelete(productId);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return repository.findByProductName(productName);
    }
}
