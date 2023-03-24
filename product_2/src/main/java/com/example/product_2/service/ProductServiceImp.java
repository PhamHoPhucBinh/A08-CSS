package com.example.product_2.service;
import com.example.product_2.bean.Product;
import com.example.product_2.repository.ProductRepository;
import com.example.product_2.repository.ProductRepositoryImp;

import java.util.List;
public class ProductServiceImp implements ProductService{
    private static ProductRepository productRepository = new ProductRepositoryImp();

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void delete(String id) {

        productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();

    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);

    }
}
