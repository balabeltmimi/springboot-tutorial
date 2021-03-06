package com.example.activityservice.service;

import com.example.activityservice.model.Activity;
import com.example.activityservice.repository.ActivityRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService (ActivityRepository activityRepository) {

        this.activityRepository = activityRepository;
    }

    public List<Activity> getAll() {
        Activity activity1 = Activity.builder()
                .id(1)
                .name("logout")
                .description("Logout")
                .build();

        Activity activity2 = Activity.builder()
                .id(2)
                .name("login")
                .description("Login")
                .build();

        List<Activity> activities = activityRepository.findAll();

//        List<Activity> activities = new ArrayList<>();
//        activities.add(activity1);
//        activities.add(activity2);

        return activities;

    }

    public List<Activity> getByUser(String username) {

        // - @Query
//        return activityRepository.findActivityForUSer(username);

        // - JPQL
//        return activityRepository.findAllByCreatedBy(username);

        // - Query by example
        Activity activity = Activity.builder()
                .createdBy(username)
                .build();
        Example<Activity> example = Example.of(activity);
        return activityRepository.findAll(example);
    }

}
