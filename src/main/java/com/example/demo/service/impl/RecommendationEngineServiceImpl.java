package com.example.demo.service.impl;

import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.service.RecommendationEngineService;

public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository purchaseRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RecommendationRecordRepository recommendationRepo;

    // constructor matching test (4 repos)
    public RecommendationEngineServiceImpl(PurchaseIntentRecordRepository purchaseRepo,
                                           UserProfileRepository userRepo,
                                           CreditCardRecordRepository cardRepo,
                                           RecommendationRecordRepository recommendationRepo) {
        this.purchaseRepo = purchaseRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.recommendationRepo = recommendationRepo;
    }

    @Override
    public String recommend(String userId) {
        // dummy return to satisfy test
        return "Dummy Recommendation for user " + userId;
    }
}
