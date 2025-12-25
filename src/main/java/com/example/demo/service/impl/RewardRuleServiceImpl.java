package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;

import java.util.List;

public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository repository;

    public RewardRuleServiceImpl(RewardRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RewardRule createRule(RewardRule rule) {
        return repository.save(rule);
    }

    @Override
    public RewardRule updateRule(Long id, RewardRule rule) {
        RewardRule existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));
        rule.setId(existing.getId());
        return repository.save(rule);
    }

    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return repository.findAll()
                .stream()
                .filter(r -> cardId.equals(r.getCardId()))
                .toList();
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<RewardRule> getAllRules() {
        return repository.findAll();
    }
}
