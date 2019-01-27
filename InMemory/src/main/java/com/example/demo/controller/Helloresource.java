package com.example.demo.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "rest/hello")
public class Helloresource {

    @GetMapping(value = "get")
    public String hello(@AuthenticationPrincipal final UserDetails userDetails)
    {
        String name = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.forEach(System.out::println);
        return "Hello world";
    }

}
