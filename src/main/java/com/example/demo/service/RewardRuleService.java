package com.example.demo.service;

import com.example.demo.entity.RewardRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.RewardRuleRepository;
import java.util.List;

public class RewardRuleService {

    private final RewardRuleRepository repo;

    public RewardRuleService(RewardRuleRepository repo) {
        this.repo = repo;
    }

    public RewardRule createRule(RewardRule rule) {
        if (rule.getMultiplier() <= 0) {
            throw new BadRequestException("Price multiplier must be > 0");
        }
        return repo.save(rule);
    }

    public List<RewardRule> getActiveRules() {
        return repo.findByActiveTrue();
    }
}
