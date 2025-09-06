package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RoleRepo extends JpaRepository<Role, Integer> {
    public Role findByNameContainingIgnoreCase(String name);
    @Modifying
    @Query("UPDATE User u SET u.role = null WHERE u.role.id = :roleId")
    public void clearRoleFromUsers(@Param("roleId") Integer roleId);

}
