package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

public class RecommendationEngineService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RewardRuleRepository ruleRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineService(
            PurchaseIntentRecordRepository intentRepo,
            UserProfileRepository userRepo,
            CreditCardRecordRepository cardRepo,
            RewardRuleRepository ruleRepo,
            RecommendationRecordRepository recRepo) {

        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.ruleRepo = ruleRepo;
        this.recRepo = recRepo;
    }

    public RecommendationRecord generateRecommendation(Long intentId) {

        PurchaseIntentRecord intent = intentRepo.findById(intentId).orElseThrow();
        List<CreditCardRecord> cards = cardRepo.findActiveCardsByUser(intent.getUserId());

        double bestValue = 0;
        Long bestCard = null;

        for (CreditCardRecord card : cards) {
            List<RewardRule> rules =
                    ruleRepo.findActiveRulesForCardCategory(card.getId(), intent.getCategory());

            for (RewardRule rule : rules) {
                double value = intent.getAmount() * rule.getMultiplier();
                if (value > bestValue) {
                    bestValue = value;
                    bestCard = card.getId();
                }
            }
        }

        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(intent.getUserId());
        rec.setPurchaseIntentId(intentId);
        rec.setRecommendedCardId(bestCard);
        rec.setExpectedRewardValue(bestValue);
        rec.setCalculationDetailsJson("{}");

        return recRepo.save(rec);
    }
}
