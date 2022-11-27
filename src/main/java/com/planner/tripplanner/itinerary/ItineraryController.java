package com.planner.tripplanner.itinerary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ItineraryController {
    @Autowired
    private ItineraryService itineraryService;

    @GetMapping("/itineraries")
    public String getItineraries(Model model) {
        ArrayList<Itinerary> itineraryList = itineraryService.addExampleItineraries();
        model.addAttribute("itineraryList", itineraryList);
        return "itinerariesPage";
    }
}
