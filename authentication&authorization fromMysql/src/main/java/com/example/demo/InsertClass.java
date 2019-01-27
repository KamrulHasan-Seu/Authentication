package com.example.demo;

import com.example.demo.model.Roles;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class InsertClass {
    private UserService userService;
    private RoleService roleService;

    public InsertClass(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

        List<Roles> rolesSet = new ArrayList<>();
        Roles roles = new Roles("ADMIN");
        rolesSet.add(roles);
        roleService.saveRole(roles);

        User user = new User("Kamrul", 25,"test", 1, rolesSet);
        userService.saveUser(user);
    }
}
