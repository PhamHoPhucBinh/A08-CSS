package com.example.product_2.repository;
import com.example.product_2.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductRepositoryImp implements ProductRepository {
    private static Map<String , Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put("01",new Product("01","television",12000,"new"));
        productMap.put("02",new Product("02","phone",13000,"new"));
        productMap.put("03",new Product("03","bike",14000,"old"));
        productMap.put("04",new Product("04","table",15000,"old"));
    }
    @Override
    public void create(Product product) {

        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }
    @Override
    public void delete(String id) {
        productMap.remove(id);

    }

    @Override
    public void update(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());

    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

}
