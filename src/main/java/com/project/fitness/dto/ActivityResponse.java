package com.project.fitness.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.fitness.model.ActivityType;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {

    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesburned;
    private LocalDate startTime;
    private LocalDate creaedAt;
    private LocalDateTime updatedAt;
    private Map<String, Object> attributes;

}












