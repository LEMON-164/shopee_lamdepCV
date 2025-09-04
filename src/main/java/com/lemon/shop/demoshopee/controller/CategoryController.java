package com.lemon.shop.demoshopee.controller;

import com.lemon.shop.demoshopee.entity.Category;
import com.lemon.shop.demoshopee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping("/newCategory")
    public void createCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping("/updateCategory")
    public void updateCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("/removeCategory")
    public void removeCategory(@RequestBody Category category) {
        categoryService.remove(category);
    }
}
