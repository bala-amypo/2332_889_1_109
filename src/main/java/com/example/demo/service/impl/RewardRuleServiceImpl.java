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
    public RewardRule createRule(RewardRule rewardRule) {
        return rewardRuleRepository.save(rewardRule);
    }
    
    @Override
    public RewardRule updateRule(Long id, RewardRule rewardRule) {
        rewardRule.setId(id);
        return rewardRuleRepository.save(rewardRule);
    }
    
    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return rewardRuleRepository.findByCardId(cardId);
    }
    
    @Override
    public List<RewardRule> getActiveRules() {
        return rewardRuleRepository.findByIsActiveTrue();
    }
    
    @Override
    public List<RewardRule> getAllRules() {
        return rewardRuleRepository.findAll();
    }
}