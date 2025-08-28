package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductRepo extends JpaRepository<Product, String> {
    public Optional<Product> findById(String id);
}
