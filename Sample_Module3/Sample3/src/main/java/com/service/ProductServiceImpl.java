package com.service;

import com.model.Product;
import com.repository.ProductRepository;
import com.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public Product findById(int productId) {
        return repository.findById(productId);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
