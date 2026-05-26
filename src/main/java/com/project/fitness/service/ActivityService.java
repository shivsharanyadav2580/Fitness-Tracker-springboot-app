package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final AuthRepository authRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = authRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("user not found" + request.getUserId()));
        Activity activity = Activity.builder()
                .user(user)
                        .type(request.getType())
                                .duration(request.getDuration())
                                        .caloriesburned(request.getCaloriesburned())
                                                .startTime(request.getStartTime())
                                                        .attributes(request.getAttributes())

                                                                .build();
       Activity savedActivity =  activityRepository.save(activity);
       return mapToResponse(savedActivity);

    }
    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setUserId(activity.getUser().getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesburned(activity.getCaloriesburned());
        response.setStartTime(activity.getStartTime());
        response.setAttributes(activity.getAttributes());

        return response;
    }

    public  List<ActivityResponse> getActivityByUserId(String userId){
        List<Activity> activities = activityRepository.findByUserId(userId);
        return activities.stream()
                .map(activity -> mapToResponse(activity))
                .collect(Collectors.toList());
    }
}
