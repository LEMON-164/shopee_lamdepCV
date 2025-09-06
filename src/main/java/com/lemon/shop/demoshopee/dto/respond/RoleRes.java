package com.lemon.shop.demoshopee.dto.respond;

public class RoleRes {
    private String name;
    private String description;

    public RoleRes() {
    }

    public RoleRes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
