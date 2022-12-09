package com.planner.tripplanner.itinerary;

import com.planner.tripplanner.activity.Activity;
import com.planner.tripplanner.activity.ActivityService;
import com.planner.tripplanner.budget.BudgetService;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ItineraryController {
    @Autowired
    private ItineraryService itineraryService;

    @Autowired
    private ActivityService activityService;

    @GetMapping("/itineraries")
    public String getItineraries(Model model) {
//        itineraryService.addExampleItineraries();
        ArrayList<Itinerary> itineraryList = itineraryService.getItineraries();
        model.addAttribute("itineraryList", itineraryList);
        return "itinerariesPage";
    }

    @PostMapping("/itineraries")
    public String addItinerary(@RequestParam String itineraryName, String itineraryDestination, String itineraryDuration, String itineraryBudget) {
        itineraryService.addItineraryStrings(itineraryName, itineraryDestination, itineraryDuration, itineraryBudget);
        return "redirect:/itineraries";
    }

    @GetMapping ("/itineraries/{idItinerary}")
    public String getItineraryInfo(@PathVariable String idItinerary, Model model) {
        Itinerary itinerary = itineraryService.getItineraryById(Long.valueOf(idItinerary));
        model.addAttribute("itinerary", itinerary);
        return "itineraryPage";
    }

    @PostMapping("/itineraries/{idItinerary}")
    public String addActivity(@RequestParam String activityName, String activityDuration, String activityCost,
                              String activityCategory, String activityStatus, @PathVariable String idItinerary) {
        // Create activity from request parameters
        Activity activity = new Activity(activityName, activityCategory, activityStatus,
                Double.parseDouble(activityDuration), Double.parseDouble(activityCost));
        // Add activity to activities database and itinerary
        activityService.addActivity(activity);
        itineraryService.addActivityToItinerary(idItinerary, activity);
        return "redirect:/itineraries/{idItinerary}";
    }

    @GetMapping("/itineraries/activities/{idActivity}")
    public String viewActivity(@PathVariable String idActivity, Model model) {
        Activity activity = activityService.getActivity(Long.valueOf(idActivity));
        model.addAttribute("activity", activity);
        return "activityPage";
    }
}
