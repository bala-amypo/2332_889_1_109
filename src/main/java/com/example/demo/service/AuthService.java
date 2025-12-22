package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthService {

    private final UserProfileService userService;
    private final UserProfileRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(UserProfileService userService,
                       UserProfileRepository userRepository,
                       AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String login(String userId, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userId, password));

        return jwtUtil.generateToken(userId);
    }
}
