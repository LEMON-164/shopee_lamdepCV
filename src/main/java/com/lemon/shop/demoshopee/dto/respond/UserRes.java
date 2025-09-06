package com.lemon.shop.demoshopee.dto.respond;

public class UserRes {
    private int id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private RoleRes role;

    public UserRes() {}

    public UserRes(int id, String username, String email, String phone, String address, RoleRes role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleRes getRole() {
        return role;
    }

    public void setRole(RoleRes role) {
        this.role = role;
    }
}
