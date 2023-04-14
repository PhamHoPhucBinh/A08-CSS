package com.service;

import com.model.Category;
import com.model.Product;

import java.util.List;

public interface CategoryService {
    Category findById(int categoryId);
    List<Category> findAll();
}
