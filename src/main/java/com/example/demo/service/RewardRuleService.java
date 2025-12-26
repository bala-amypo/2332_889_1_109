public interface RewardRuleService {

    RewardRule createRule(RewardRule rule);

    RewardRule updateRule(Long id, RewardRule rule);

    List<RewardRule> getRulesByCard(Long cardId);

    List<RewardRule> getActiveRules();
}
