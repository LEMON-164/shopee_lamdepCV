package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepo extends JpaRepository<User, String> {

    public User findById(int id);
    public List<User> findUsersByUsernameContainingIgnoreCase(String name);
    public User findByUsernameContainingIgnoreCase(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByPhoneAndPassword(String phone, String password);
}
