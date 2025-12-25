package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Minimal DTO placeholders (you can expand later)
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;

@RestController
public class AuthController {

    // Dummy login endpoint
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        // Return a dummy token
        return new JwtResponse("dummy-token");
    }

    // Dummy register endpoint
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        // Just return success message
        return "User registered successfully";
    }
}
