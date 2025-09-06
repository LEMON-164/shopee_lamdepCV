package com.lemon.shop.demoshopee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "role")
@AllArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", columnDefinition = "BIGINT")
    private int id;

    @Column(name = "Name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(200)")
    private String description;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
        user.setRole(this);
    }
    public void removeUser(User user) {
        users.remove(user);
        user.setRole(null);
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
