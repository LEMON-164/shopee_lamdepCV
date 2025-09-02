package com.lemon.shop.demoshopee.controller;

import com.lemon.shop.demoshopee.entity.Product;
import com.lemon.shop.demoshopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @DeleteMapping("/removeProduct")
    public void removeProduct(@RequestBody Product product) {
        productService.remove(product);
    }
}
