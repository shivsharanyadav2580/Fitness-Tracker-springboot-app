package com.project.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReccomendationRequest {

    private String userId;
    private String activityId;
    private String reccomendationId;

    private String  type;
    private String recommendation;
    private List<String> improovement;
    private  List<String> suggestions;
    private  List<String> safety;

}
