package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile createUser(UserProfile user) {
        return userProfileRepository.save(user);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    @Override
    public void updateUserStatus(Long id, boolean active) {
        userProfileRepository.findById(id).ifPresent(u -> {
            u.setActive(active);
            userProfileRepository.save(u);
        });
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return userProfileRepository.findByUserId(userId);
    }
}
