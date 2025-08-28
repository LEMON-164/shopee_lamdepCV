package com.lemon.shop.demoshopee.service;


import com.lemon.shop.demoshopee.entity.Product;
import com.lemon.shop.demoshopee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findById(String id) {
        return productRepo.findById(id).get();
    }

    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
}
