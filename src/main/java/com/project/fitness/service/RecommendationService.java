package com.project.fitness.service;

import com.project.fitness.dto.ReccomendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.AuthRepository;
import com.project.fitness.repository.RecommendatioonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

   private final RecommendatioonRepository recommendationRepository;
   private final ActivityRepository  activityRepository;
   private final AuthRepository   authRepository;



   public Recommendation generateRecommendation(ReccomendationRequest request) {

      User user = authRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found" + request.getUserId()));


      Activity activity = activityRepository.findById(request.getActivityId()).orElseThrow(() -> new RuntimeException("Activity not found" + request.getActivityId()));

      Recommendation recommendation = Recommendation.builder()
              .user(user)
              .activity(activity)
              .improovement(request.getImproovement())
              .suggestions(request.getSuggestions())
              .type(request.getType())
              .build();

      return recommendationRepository.save(recommendation);
   }
   public List<Recommendation> getReCommendation(String userId) {
      return  recommendationRepository.findByUser_Id(userId);




   }
}












