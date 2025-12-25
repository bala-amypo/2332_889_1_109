package com.example.demo.service.impl;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository purchaseRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository creditRepo;
    private final RecommendationRecordRepository recommendationRepo;

    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository purchaseRepo,
            UserProfileRepository userRepo,
            CreditCardRecordRepository creditRepo,
            RecommendationRecordRepository recommendationRepo
    ) {
        this.purchaseRepo = purchaseRepo;
        this.userRepo = userRepo;
        this.creditRepo = creditRepo;
        this.recommendationRepo = recommendationRepo;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long userId) {
        // TODO: implement recommendation logic
        return null;
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRepo.findByUserId(userId);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recommendationRepo.findById(id).orElse(null);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRepo.findAll();
    }
}
