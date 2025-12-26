package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile user) {
        return userProfileService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserProfile getUser(@PathVariable Long id) {
        return userProfileService.getUserById(id);
    }

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @PutMapping("/{id}/{status}")
    public UserProfile updateStatus(@PathVariable Long id,
                                    @PathVariable boolean status) {
        return userProfileService.updateUserStatus(id, status);
    }
}
