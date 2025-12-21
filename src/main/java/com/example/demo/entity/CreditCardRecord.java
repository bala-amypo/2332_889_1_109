package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 1337]
    private String userId; [cite: 1337]
    private String cardName; [cite: 1337]
    private String issuer; [cite: 1337]
    private String cardType; [cite: 1337]
    private Double annualFee; [cite: 1337]
    private String status = "ACTIVE"; [cite: 1337]
    private LocalDateTime createdAt; [cite: 1337]

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } [cite: 1337]

    // Getters and Setters
}