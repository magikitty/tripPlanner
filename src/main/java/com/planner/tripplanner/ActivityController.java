package com.planner.tripplanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ActivityController {
    @GetMapping("/activities")
    public String getActivities(Model model) {
        ArrayList<Activity> activitiesList = new ArrayList<>();
        Activity hike = new Activity("Hike up Table Mountain", "nature", "to-do", 3.5, 0.0);
        Activity eat = new Activity("Eat at Primi Piatti's", "restaurant", "to-do", 2.0, 100.0);
        activitiesList.add(hike);
        activitiesList.add(eat);

        model.addAttribute("activitiesList", activitiesList);
        return "activitiesPage";
    }
}
