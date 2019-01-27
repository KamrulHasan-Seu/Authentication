package com.example.demo;

import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

        UserService userService = run.getBean(UserService.class);
        RoleService roleService = run.getBean(RoleService.class);

        new InsertClass(userService, roleService);
    }

}

