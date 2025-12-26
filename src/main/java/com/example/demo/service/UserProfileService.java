package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface UserProfileService {
    UserProfile getUserProfile(String userId);
    UserProfile findByUserId(String userId); // Add this if it's missing
}