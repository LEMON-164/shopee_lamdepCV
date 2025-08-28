package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.entity.Role;
import com.lemon.shop.demoshopee.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public Role findbyname(String name){
        return roleRepo.findByName(name);
    }

    public void save(Role role) {
        roleRepo.save(role);
    }

    public void delete(Role role) {
        roleRepo.delete(role);
    }
}
