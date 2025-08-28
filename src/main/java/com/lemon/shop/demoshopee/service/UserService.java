package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.repository.UserRepo;
import com.lemon.shop.demoshopee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

}
