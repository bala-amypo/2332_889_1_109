package com.example.demo.service;

import com.example.demo.entity.RewardRule;
import java.util.List;

public interface RewardRuleService {
    RewardRule createRule(RewardRule rewardRule);
    RewardRule updateRule(Long id, RewardRule rewardRule);
    List<RewardRule> getRulesByCard(Long cardId);
    List<RewardRule> getActiveRules();
    List<RewardRule> getAllRules(); // Add this method
}