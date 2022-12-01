package com.planner.tripplanner.itinerary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItineraryService {
    @Autowired
    private ItineraryRepository itineraryRepository;

    public void addExampleItineraries() {
        Itinerary itinerary1 = new Itinerary("Cape Town", 10);
        Itinerary itinerary2 = new Itinerary("Bangkok", 7);
        this.itineraryRepository.save(itinerary1);
        this.itineraryRepository.save(itinerary2);
    }

    public ArrayList<Itinerary> getItineraries() {
        ArrayList<Itinerary> itineraries = this.itineraryRepository.findAll();
        return itineraries;
    }

    public Itinerary getItineraryById(Long id) {
        return this.itineraryRepository.getReferenceById(id);
    }
}
