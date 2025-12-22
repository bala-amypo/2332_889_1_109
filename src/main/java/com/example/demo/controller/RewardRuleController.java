package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reward-rules")
@Tag(name = "Reward Rules")
public class RewardRuleController {

    private final RewardRuleService ruleService;

    public RewardRuleController(RewardRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public RewardRule createRule(@RequestBody RewardRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public RewardRule updateRule(@PathVariable Long id,
                                 @RequestBody RewardRule updated) {
        return ruleService.updateRule(id, updated);
    }

    @GetMapping("/card/{cardId}")
    public List<RewardRule> getRulesByCard(@PathVariable Long cardId) {
        return ruleService.getRulesByCard(cardId);
    }

    @GetMapping("/active")
    public List<RewardRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping
    public List<RewardRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
