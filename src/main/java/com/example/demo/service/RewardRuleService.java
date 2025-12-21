package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserProfileServiceImpl(UserProfileRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile register(UserProfile user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public UserProfile findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
}