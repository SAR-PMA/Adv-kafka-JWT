package com.example.kafka_consumer_app.controller;

import com.example.kafka_consumer_app.entity.LoginRequest;
import com.example.kafka_consumer_app.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

//        @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        Authentication auth = authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        return jwtUtil.generateToken(auth.getName()); // `auth.getName()` = username
//    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        System.out.println("Login request received for user: " + request.getUsername());
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return jwtUtil.generateToken(auth.getName());
    }

}
