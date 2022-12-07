package com.planner.tripplanner.itinerary;

import com.planner.tripplanner.activity.Activity;
import com.planner.tripplanner.activity.ActivityService;
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
    public String addItinerary(@RequestParam String itineraryName, String itineraryDestination, String itineraryDuration) {
        itineraryService.addItineraryStrings(itineraryName, itineraryDestination, itineraryDuration);
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
        Activity activity = new Activity(activityName, activityCategory, activityStatus,
                Double.parseDouble(activityDuration), Double.parseDouble(activityCost));
        activityService.addActivity(activity);
        // Get itinerary object from page Model
//        Itinerary itinerary = (Itinerary) model.getAttribute("itinerary");

        itineraryService.addActivityToItinerary(idItinerary, activity);
        return "redirect:/itineraries/{idItinerary}";
    }
}
