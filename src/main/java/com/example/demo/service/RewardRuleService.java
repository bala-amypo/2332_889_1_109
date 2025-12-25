package com.example.demo.service;

import com.example.demo.entity.RewardRule;

import java.util.List;

public interface RewardRuleService {

    List<RewardRule> getAllRules();

    RewardRule getRewardRuleById(Long id);

    RewardRule saveRewardRule(RewardRule rule);

    void deleteRewardRule(Long id);
}
