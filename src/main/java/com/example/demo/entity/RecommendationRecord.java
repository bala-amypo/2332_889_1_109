package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private Double expectedRewardValue;

    @Lob
    private String calculationDetailsJson;

    private LocalDateTime recommendedAt;

    @PrePersist
    void onCreate() {
        recommendedAt = LocalDateTime.now();
    }

    // getters & setters
}
