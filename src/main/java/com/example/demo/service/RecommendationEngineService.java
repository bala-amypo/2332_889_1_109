package com.example.demo.service;

import com.example.demo.entity.Recommendation;
import java.util.List;

public interface RecommendationEngineService {

    List<Recommendation> getAllRecommendations();
}
