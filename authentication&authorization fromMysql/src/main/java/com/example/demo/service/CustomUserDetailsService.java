package com.example.demo.service;

import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(userName);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("user name does not exist"));

        return optionalUser.map(user -> {
            return new CustomUserDetails(user);
        }).get();
    }
}
