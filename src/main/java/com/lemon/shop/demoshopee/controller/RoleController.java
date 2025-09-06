package com.lemon.shop.demoshopee.controller;

import com.lemon.shop.demoshopee.dto.request.RoleReq;
import com.lemon.shop.demoshopee.dto.respond.RoleRes;
import com.lemon.shop.demoshopee.entity.Role;
import com.lemon.shop.demoshopee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roleList")
    public List<RoleRes> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping("/addRole")
    public void addRole(@RequestBody RoleReq dto) {
        roleService.addRole(dto);
    }

    @PutMapping("/updateRole/{id}")
    public void updateRole(@PathVariable("id") int id, @RequestBody RoleReq dto) {
        roleService.updateRole(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removeRole(@PathVariable("id") int id) {
        roleService.removeRole(id);
    }
}
