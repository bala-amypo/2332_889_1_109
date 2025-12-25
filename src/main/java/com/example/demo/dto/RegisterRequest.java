package com.example.demo.dto;

public class RegisterRequest {
    private String fullName;
    private String email;
    private String role;

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
