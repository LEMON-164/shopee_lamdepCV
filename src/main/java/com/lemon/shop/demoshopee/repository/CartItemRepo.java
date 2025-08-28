package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

}
