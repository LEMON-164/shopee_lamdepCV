package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.repository.CategoryRepo;
import com.lemon.shop.demoshopee.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public void remove(Category category) {
        categoryRepo.delete(category);
    }
}
