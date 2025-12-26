@Service
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
        rule.setId(id);
        return repository.save(rule);
    }

    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return repository.findByCardId(cardId);
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
