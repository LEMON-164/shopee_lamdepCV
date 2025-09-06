package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.dto.request.RoleReq;
import com.lemon.shop.demoshopee.dto.respond.RoleRes;
import com.lemon.shop.demoshopee.entity.Role;
import com.lemon.shop.demoshopee.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public List<RoleRes> getAllRoles() {
        return roleRepo.findAll().stream().map(role -> {
            RoleRes dto = new RoleRes();
            dto.setName(role.getName());
            dto.setDescription(role.getDescription());
            return dto;
        }).collect(Collectors.toList());
    }

    public void addRole(RoleReq dto) {
        Role role = roleRepo.findByNameContainingIgnoreCase(dto.getName());
        if (role != null) {
            role = new Role(dto.getName(), dto.getDescription());
        }
        roleRepo.save(role);
    }

    public void updateRole(int id, RoleReq dto) {
        Optional<Role> role = roleRepo.findById(id);
        if (role.isPresent()) {
            if (!dto.getName().isEmpty()){
                role.get().setName(dto.getName());
            }
            if (!dto.getDescription().isEmpty()){
                role.get().setDescription(dto.getDescription());
            }
            roleRepo.save(role.get());
        }
    }

    public void removeRole(int id) {
        Optional<Role> role = roleRepo.findById(id);
        if (role.isPresent()) {
            roleRepo.clearRoleFromUsers(id);
            roleRepo.delete(role.get());
        }
    }
}
