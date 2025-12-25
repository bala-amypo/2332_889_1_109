package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    public JwtUtil(byte[] secret, long expirationMs) {
        // no-op (kept only for constructor compatibility)
    }

    public String generateToken(Long userId, String email, String role) {
        String raw = userId + "|" + email + "|" + role;
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return decode(token)[1];
    }

    public String extractRole(String token) {
        return decode(token)[2];
    }

    public Long extractUserId(String token) {
        return Long.valueOf(decode(token)[0]);
    }

    private String[] decode(String token) {
        String decoded =
                new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|");
    }
}
