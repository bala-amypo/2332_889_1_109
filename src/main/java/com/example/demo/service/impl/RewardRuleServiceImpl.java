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
