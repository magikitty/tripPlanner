package com.planner.tripplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public void addExampleActivities() {
//        this.activityRepository.deleteAll();    // clear database
        Activity hike = new Activity("Hike up Table Mountain", "nature", "to-do", 3.5, 0.0);
        Activity eat = new Activity("Eat at Primi Piatti's", "restaurant", "to-do", 2.0, 100.0);
        this.activityRepository.save(hike);
        this.activityRepository.save(eat);
        System.out.println("hike id: " + hike.getId()); // debugging
        System.out.println("eat id: " + eat.getId());   // debugging
    }

    public void addActivity(String nameActivity) {
        Activity activity = new Activity(nameActivity);
        this.activityRepository.save(activity);
    }

    public Activity getActivityByName(String name) {
        return activityRepository.findByName(name).get(0);
    }

    public Activity getActivity(Long id) {
        return activityRepository.findById(id).get();
    }

    public ArrayList<Activity> getActivities() {
        return this.activityRepository.findAll();
    }
}
