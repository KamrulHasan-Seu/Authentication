package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String password;
    private int active;
    @OneToMany
    private List<Roles> roles;

    public User(String name, int age, String password, int active, List<Roles> roles) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public User(User user) {
        this.active = user.getActive();
        this.age = user.getAge();
        this.name = user.getName();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.id = user.getId();
    }
}
