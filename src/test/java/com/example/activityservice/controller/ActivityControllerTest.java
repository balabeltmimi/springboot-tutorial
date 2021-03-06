package com.example.activityservice.controller;

import com.example.activityservice.model.Activity;
import com.example.activityservice.service.ActivityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActivityControllerTest {

    @Mock
    private ActivityService activityService;

    @InjectMocks
    private ActivityController activityController;

    @Test
    void getActivityTest() {

        Activity activity1 = new Activity();
        activity1.setName("Logout");
        Activity activity2 = new Activity();

        List<Activity> activities = List.of(activity1, activity2);
        Mockito.when(activityService.getAll()).thenReturn(activities);

        ActivityService activityService = new ActivityService();
        ActivityController activityController = new ActivityController(activityService);

        List<Activity> actual = activityController.getActivity();

        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals("Logout", actual.get(0).getName());
    }
}