package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.entity.CartItem;
import com.lemon.shop.demoshopee.repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;

    public List<CartItem> findAll() {
        return cartItemRepo.findAll();
    }

    public void save(CartItem cartItem) {
        cartItemRepo.save(cartItem);
    }

    public void remove(CartItem cartItem) {
        cartItemRepo.delete(cartItem);
    }
}
