package com.repository;

import com.model.Category;
import com.model.Product;

import java.util.List;

public interface CategoryRepository {
    Category findById(int categoryId);
    List<Category> findAll();
}
