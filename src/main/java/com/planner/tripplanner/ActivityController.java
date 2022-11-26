package com.planner.tripplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/activities")
    public String getActivities(Model model) {
        // Add example activities to database
//        this.activityService.addExampleActivities();
        ArrayList<Activity> activitiesList = activityService.getActivities();
        // Add activities to model for front end
        model.addAttribute("activitiesList", activitiesList);
        // Return HTML page with the model
        return "activitiesPage";
    }

    @GetMapping("/activities/{idActivity}")
    public String getActivityInfoId(@PathVariable String idActivity, Model model) {
        Activity activity = activityService.getActivity(Long.valueOf(idActivity));
        model.addAttribute("activity", activity);
        return "activityPage";
    }

    @PostMapping("/activities")
    public String addActivity(@RequestParam String activityName, String activityDuration, String activityCost,
                              String activityCategory, String activityStatus) {
        Activity activity = new Activity(activityName, activityCategory, activityStatus,
                Double.parseDouble(activityDuration), Double.parseDouble(activityCost));
        activityService.addActivity(activity);
        return "redirect:/activities";
    }
}
