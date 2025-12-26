package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    
    private final UserProfileRepository userProfileRepository;
    
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
    
    @Override
    public UserProfile getUserProfile(String userId) {
        return userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    @Override
    public UserProfile findByUserId(String userId) {
        return userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}