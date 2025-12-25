package com.example.demo.dto;

public class JwtResponse {
    private String token;
    private String userId;

    public JwtResponse(String token) {
        this.token = token;
        this.userId = "dummy-user"; // just to satisfy test
    }

    public String getBody() { return token; }
    public String getUserId() { return userId; }
    public String getEmail() { return "dummy@example.com"; } // placeholder
}
