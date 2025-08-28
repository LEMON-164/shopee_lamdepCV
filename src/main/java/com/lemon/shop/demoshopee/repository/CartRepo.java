package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.Cart;
import com.lemon.shop.demoshopee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CartRepo extends JpaRepository<Cart, Integer> {

    public Cart getCartByUser(User user);
}
