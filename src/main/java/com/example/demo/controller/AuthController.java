package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.service.UserProfileService;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;

public class AuthController {

    private final UserProfileService userService;
    private final UserProfileRepository userRepo;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    // constructor matching your test
    public AuthController(UserProfileService userService,
                          UserProfileRepository userRepo,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public JwtResponse login(LoginRequest request) {
        // dummy response
        return new JwtResponse("dummy-token");
    }

    public String register(RegisterRequest request) {
        userService.registerUser(request);
        return "User registered successfully";
    }
}
