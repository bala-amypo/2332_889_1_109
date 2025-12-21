package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserProfileService {

    private final UserProfileRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserProfileService(UserProfileRepository repository,
                              PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserProfile createUser(UserProfile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profile.setActive(true);
        return repository.save(profile);
    }

    public UserProfile getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserProfile findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    public UserProfile updateUserStatus(Long id, boolean active) {
        UserProfile user = getUserById(id);
        user.setActive(active);
        return repository.save(user);
    }
}
