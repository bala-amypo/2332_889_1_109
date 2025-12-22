package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 1328]
    private String userId; [cite: 1328]
    private String fullName; [cite: 1328]
    private String email; [cite: 1328]
    private String password; [cite: 1328]
    private String role = "USER"; [cite: 1328]
    private Boolean active = true; [cite: 1328]
    private LocalDateTime createdAt; [cite: 1328]

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "card_intent_mapping")
    private Set<CreditCardRecord> favouriteCards; [cite: 1328, 1334]

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } [cite: 1332]

    // Getters and Setters omitted for brevity
}