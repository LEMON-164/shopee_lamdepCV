package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.dto.request.UserAuthenReq;
import com.lemon.shop.demoshopee.dto.request.UserProfileReq;
import com.lemon.shop.demoshopee.dto.respond.RoleRes;
import com.lemon.shop.demoshopee.dto.respond.UserRes;
import com.lemon.shop.demoshopee.entity.Role;
import com.lemon.shop.demoshopee.repository.RoleRepo;
import com.lemon.shop.demoshopee.repository.UserRepo;
import com.lemon.shop.demoshopee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", Pattern.CASE_INSENSITIVE);

    // Hợp lệ cho VN: 10-digit bắt đầu 03|05|07|08|09 OR old 11-digit 01(2|6|8|9)
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^(?:(?:03|05|07|08|09)\\d{8}|01(?:2|6|8|9)\\d{8})$");

    public List<UserRes> getAllUsers() {
        return userRepo.findAll().stream().map(user -> {
            UserRes dto = new UserRes();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setAddress(user.getAddress());
            dto.setRole(new RoleRes(user.getRole().getName(), user.getRole().getDescription()));
            return dto;
        }).collect(Collectors.toList());
    }


    public UserRes findByUserId(int id) {
        User user = userRepo.findById(id);
        if (user != null) {
            return new UserRes(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getAddress(), new RoleRes(user.getRole() != null ? user.getRole().getName() : null, user.getRole() != null ? user.getRole().getDescription() : null));
        } else {
            return null;
        }
    }

    public void registerUser(UserAuthenReq dto) {
        User user = new User();
        Role role = roleRepo.findByNameContainingIgnoreCase("Customer");

        user.setRole(role);
        if (dto.getEmail() != null && EMAIL_PATTERN.matcher(dto.getEmail()).matches()){
            user.setEmail(dto.getEmail());
        }
        user.setPassword(dto.getPassword());
        if(dto.getPhone() != null && PHONE_PATTERN.matcher(dto.getPhone()).matches()) {
            user.setPhone(dto.getPhone());
        }
        role.addUser(user);
        userRepo.save(user);
    }

    public void registerAdmin(UserAuthenReq dto) {
        User user = new User();
        Role role = roleRepo.findByNameContainingIgnoreCase("Admin");

        user.setRole(role);
        if (dto.getEmail() != null && EMAIL_PATTERN.matcher(dto.getEmail()).matches()){
            user.setEmail(dto.getEmail());
        }
        user.setPassword(dto.getPassword());
        if(dto.getPhone() != null && PHONE_PATTERN.matcher(dto.getPhone()).matches()) {
            user.setPhone(dto.getPhone());
        }
        role.addUser(user);
        userRepo.save(user);
    }

    public void updateProfile(int id, UserProfileReq dto){
        User user = userRepo.findById(id);
        if(user != null){

            if(dto.getPhone() != null && PHONE_PATTERN.matcher(dto.getPhone()).matches()){
                user.setPhone(dto.getPhone());
            }
            if (dto.getEmail() != null && EMAIL_PATTERN.matcher(dto.getEmail()).matches()){
                user.setEmail(dto.getEmail());
            }
            if(dto.getUsername() != null){
                user.setUsername(dto.getUsername());
            }
            if(dto.getAddress() != null){
                user.setAddress(dto.getAddress());
            }

            userRepo.save(user);
        }
    }

    public void removeUser(int id) {
        User user = userRepo.findById(id);
        Role role = roleRepo.findByNameContainingIgnoreCase(user.getRole().getName());
        if(user != null && role != null){
            role.removeUser(user);
            userRepo.delete(user);
        }
    }
}
