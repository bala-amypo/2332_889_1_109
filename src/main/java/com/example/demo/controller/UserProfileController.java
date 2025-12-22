package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users") [cite: 1492]
public class UserProfileController {
    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping("/register") [cite: 1495]
    public ResponseEntity<UserProfile> register(@RequestBody UserProfile user) {
        return ResponseEntity.ok(service.register(user)); [cite: 1499]
    }
}