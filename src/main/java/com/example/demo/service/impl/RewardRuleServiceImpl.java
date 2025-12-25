package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository rewardRuleRepository;

    public RewardRuleServiceImpl(RewardRuleRepository rewardRuleRepository) {
        this.rewardRuleRepository = rewardRuleRepository;
    }

    @Override
    public RewardRule saveRewardRule(RewardRule rule) {
        return rewardRuleRepository.save(rule);
    }

    @Override
    public List<RewardRule> getAllRewardRules() {
        return rewardRuleRepository.findAll();
    }

    @Override
    public RewardRule getRewardRuleById(Long id) {
        return rewardRuleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRewardRule(Long id) {
        rewardRuleRepository.deleteById(id);
    }
}
