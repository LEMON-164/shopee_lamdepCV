package com.lemon.shop.demoshopee.configuration;

import com.lemon.shop.demoshopee.entity.Role;
import com.lemon.shop.demoshopee.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitilizer implements CommandLineRunner {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        Role role1 = new Role("Admin", "Manage the entire system");
        Role role2 = new Role("Customer", "Customer is king");

        roleRepo.save(role1);
        roleRepo.save(role2);
    }
}
