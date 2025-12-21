package com.example.demo.service;
import com.example.demo.entity.UserProfile;

public interface UserProfileService {
    UserProfile register(UserProfile user); [cite: 1405]
    UserProfile findByEmail(String email); [cite: 1411]
}