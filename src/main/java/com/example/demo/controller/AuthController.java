package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserProfile register(@RequestBody UserProfile profile) {
        return authService.register(profile);
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password) {
        return authService.login(userId, password);
    }
}
