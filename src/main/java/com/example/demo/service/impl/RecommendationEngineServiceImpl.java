@Override
public RecommendationRecord getRecommendationById(Long id) {
    return recRepo.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Recommendation not found"));
}
