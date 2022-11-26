package com.planner.tripplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public void addExampleActivities() {
        this.activityRepository.deleteAll();    // clear database
        Activity hike = new Activity("Hike up Table Mountain", "nature", "to-do", 3.5, 0.0);
        Activity eat = new Activity("Eat at Primi Piatti's", "restaurant", "to-do", 2.0, 100.0);
        this.activityRepository.save(hike);
        this.activityRepository.save(eat);

//        Activity test = this.activityRepository.save(hike);
//        Long testId = this.activityRepository.save(hike).getId();  // works
//        System.out.println("ACTIVITY saved: " + testId);  // works
//        System.out.println("ID FOR EAT ACTIVITY " + eat.getId());  // doesn't work

    }

    public void addActivity(String nameActivity) {
        Activity activity = new Activity(nameActivity);
        this.activityRepository.save(activity);
    }

    public Activity getActivity(String name) {
        return activityRepository.findByName(name).get(0);
    }

    public ArrayList<Activity> getActivities() {
        return this.activityRepository.findAll();
    }
}
