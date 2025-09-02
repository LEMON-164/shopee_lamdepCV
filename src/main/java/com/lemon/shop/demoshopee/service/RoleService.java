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

    public void save(Role role) {
        roleRepo.save(role);
    }

    public void remove(Role role) {
        roleRepo.delete(role);
    }
}
