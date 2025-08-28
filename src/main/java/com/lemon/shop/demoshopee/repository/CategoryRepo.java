package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

    public List<Category> findCategoriesByNameContainingIgnoreCase(String name);


}
