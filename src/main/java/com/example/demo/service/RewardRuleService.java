package com.example.demo.service;

import com.example.demo.entity.RewardRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RewardRuleRepository;

import java.util.List;

public class RewardRuleService {

    private final RewardRuleRepository repository;

    public RewardRuleService(RewardRuleRepository repository) {
        this.repository = repository;
    }

    public RewardRule createRule(RewardRule rule) {
        if (rule.getMultiplier() == null || rule.getMultiplier() <= 0) {
            throw new BadRequestException("Price multiplier must be > 0");
        }
        return repository.save(rule);
    }

    public RewardRule updateRule(Long id, RewardRule updated) {
        RewardRule rule = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        rule.setCategory(updated.getCategory());
        rule.setRewardType(updated.getRewardType());
        rule.setMultiplier(updated.getMultiplier());
        rule.setActive(updated.getActive());

        return repository.save(rule);
    }

    public List<RewardRule> getRulesByCard(Long cardId) {
        return repository.findAll()
                .stream()
                .filter(r -> r.getCardId().equals(cardId))
                .toList();
    }

    public List<RewardRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public List<RewardRule> getAllRules() {
        return repository.findAll();
    }
}
