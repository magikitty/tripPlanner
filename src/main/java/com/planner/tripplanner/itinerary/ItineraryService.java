package com.planner.tripplanner.itinerary;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItineraryService {

    public ArrayList<Itinerary> addExampleItineraries() {
        Itinerary itinerary1 = new Itinerary("Cape Town", 10);
        Itinerary itinerary2 = new Itinerary("Bangkok", 7);
        ArrayList<Itinerary> itineraries = new ArrayList<>();
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
        return itineraries;
    }
}
