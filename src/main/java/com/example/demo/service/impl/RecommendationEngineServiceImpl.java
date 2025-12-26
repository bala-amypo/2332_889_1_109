package com.example.demo.service.impl;

import com.example.demo.entity.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationEngineServiceImpl
        implements RecommendationEngineService {

    private final RecommendationRepository repository;

    public RecommendationEngineServiceImpl(
            RecommendationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Recommendation> getAllRecommendations() {
        return repository.findAll();
    }
}
