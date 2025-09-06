package com.lemon.shop.demoshopee.dto.request;

public class UserProfileReq {
    private String username;
    private String email;
    private String phone;
    private String address;

    public UserProfileReq() {
    }

    public UserProfileReq(String username, String email, String phone, String address) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
