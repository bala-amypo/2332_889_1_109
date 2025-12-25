package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.service.UserProfileService;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;

public class AuthController {

    public AuthController(UserProfileService userProfileService,
                          UserProfileRepository userRepo,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        // store references if needed
    }

    public JwtResponse login(LoginRequest request) {
        return new JwtResponse("dummy-token");
    }

    public String register(RegisterRequest request) {
        return "User registered successfully";
    }
}
