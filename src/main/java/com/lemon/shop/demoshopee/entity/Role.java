package com.lemon.shop.demoshopee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", columnDefinition = "BIGINT")
    private int id;

    @Column(name = "RoleName", nullable = false, columnDefinition = "VARCHAR(50)")
    private String roleName;

    @Column(name = "Description", columnDefinition = "NVARCHAR(200)")
    private String description;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

}
