package com.example.demo.service.impl;

import com.example.demo.service.UserProfileService;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.dto.RegisterRequest;

public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repo;

    // constructor matching test
    public UserProfileServiceImpl(UserProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerUser(RegisterRequest request) {
        // dummy implementation
        System.out.println("Registering user: " + request.getEmail());
    }
}
