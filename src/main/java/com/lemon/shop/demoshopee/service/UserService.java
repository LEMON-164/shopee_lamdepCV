package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.repository.UserRepo;
import com.lemon.shop.demoshopee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findByUsername(String username) {
        return userRepo.findByUsernameContainingIgnoreCase(username);
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void remove(User user) {
        userRepo.delete(user);
    }

}
