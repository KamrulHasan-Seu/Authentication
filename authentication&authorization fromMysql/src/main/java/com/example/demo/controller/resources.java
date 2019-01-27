package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest")
public class resources {

    @GetMapping(value = "all")
    public String getHello() {
        return "hello world";
    }

   //@PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "secured")
    public String getSecurityresouce() {
        return "This Is for Security";
    }
}
