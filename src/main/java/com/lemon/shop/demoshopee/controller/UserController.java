package com.lemon.shop.demoshopee.controller;

import com.lemon.shop.demoshopee.dto.request.UserRegisterReq;
import com.lemon.shop.demoshopee.entity.User;
import com.lemon.shop.demoshopee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String userName) {
        return userService.findByUsername(userName);
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.save(user);
    }
}
