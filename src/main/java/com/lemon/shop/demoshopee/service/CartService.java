package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.entity.Cart;
import com.lemon.shop.demoshopee.entity.User;
import com.lemon.shop.demoshopee.repository.CartRepo;
import com.lemon.shop.demoshopee.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private UserRepo userRepo;

    public void addCart(Cart cart) {
        cartRepo.save(cart);
    }

    public Cart getCartbyUserId(int userId) {
        User user = userRepo.findById(userId).get();
        return cartRepo.getCartByUser(user);
    }

    public void removeCart(Cart cart) {
        cartRepo.delete(cart);
    }
}
