package com.lemon.shop.demoshopee.controller;

import com.lemon.shop.demoshopee.dto.request.UserAuthenReq;
import com.lemon.shop.demoshopee.dto.request.UserProfileReq;
import com.lemon.shop.demoshopee.dto.respond.UserRes;
import com.lemon.shop.demoshopee.entity.User;
import com.lemon.shop.demoshopee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/{id}")
    public UserRes getUser(@PathVariable("id") int id) {
        return userService.findByUserId(id);
    }

    @GetMapping("/userList")
    public List<UserRes> getUserList() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public void register(@RequestBody UserAuthenReq user) {
        userService.registerUser(user);
    }

    @PostMapping("/registerAdmin")
    public void registerAdmin(@RequestBody UserAuthenReq user) {
        userService.registerAdmin(user);
    }

    @PutMapping("profile/{id}")
    public void updateProfile(@PathVariable("id") int id, @RequestBody UserProfileReq dto) throws Exception {
        userService.updateProfile(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
    }
}
