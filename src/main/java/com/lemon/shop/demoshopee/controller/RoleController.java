package com.lemon.shop.demoshopee.controller;

import com.lemon.shop.demoshopee.entity.Role;
import com.lemon.shop.demoshopee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/Roles")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping("/addRole")
    public void addRole(@RequestBody Role role) {
        roleService.save(role);
    }

    @PutMapping("/updateRole")
    public void updateRole(@RequestBody Role role) {
        roleService.save(role);
    }

    @DeleteMapping("/removeRole")
    public void removeRole(@RequestBody Role role) {
        roleService.remove(role);
    }
}
