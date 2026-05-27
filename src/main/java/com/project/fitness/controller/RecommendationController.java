package com.project.fitness.controller;

import com.project.fitness.dto.ReccomendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private  final RecommendationService  recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody ReccomendationRequest request)

    {
        Recommendation  recommendation= recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/getRecomendation/{userId}")
    public ResponseEntity<List<Recommendation>> getRecomendation(

            @PathVariable String userId
    )
    {
        List<Recommendation> recommendationList = recommendationService.getReCommendation(userId);
       return ResponseEntity.ok(recommendationList);
    }

}



