package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.RecommendationRecord;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.RecommendationEngineService;

import java.util.List;

public class RecommendationEngineServiceImpl
        implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository intentRepo,
            UserProfileRepository userRepo,
            CreditCardRecordRepository cardRepo,
            RecommendationRecordRepository recRepo) {

        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.recRepo = recRepo;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {

        PurchaseIntentRecord intent = intentRepo.findById(intentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Intent not found"));

        UserProfile user = userRepo.findById(intent.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        List<CreditCardRecord> cards =
                cardRepo.findActiveCardsByUser(user.getId());

        if (cards.isEmpty()) {
            throw new BadRequestException("No active cards");
        }

        CreditCardRecord bestCard = cards.get(0);

        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(user.getId());
        rec.setPurchaseIntentId(intentId);
        rec.setRecommendedCardId(bestCard.getId());
        rec.setExpectedRewardValue(intent.getAmount());

        return recRepo.save(rec);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Recommendation not found"));
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recRepo.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recRepo.findAll();
    }
}
