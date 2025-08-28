package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
