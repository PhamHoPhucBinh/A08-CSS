package com.service;

import com.model.Category;
import com.repository.CategoryRepository;
import com.repository.CategoryRepositoryImpl;


import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository repository = new CategoryRepositoryImpl();
    @Override
    public Category findById(int categoryId) {
        return repository.findById(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
