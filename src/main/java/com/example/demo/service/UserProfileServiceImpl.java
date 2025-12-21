package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional [cite: 1399]
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository repository;
    private final PasswordEncoder encoder;

    public UserProfileServiceImpl(UserProfileRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserProfile register(UserProfile user) {
        if(repository.findByEmail(user.getEmail()).isPresent()) 
            throw new IllegalArgumentException("Email exists"); [cite: 1407]
        user.setPassword(encoder.encode(user.getPassword())); [cite: 1408]
        if(user.getRole() == null) user.setRole("USER"); [cite: 1409]
        return repository.save(user); [cite: 1410]
    }

    @Override
    public UserProfile findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Not Found")); [cite: 1413]
    }
}