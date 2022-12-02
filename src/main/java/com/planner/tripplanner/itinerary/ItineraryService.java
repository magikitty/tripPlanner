package com.planner.tripplanner.itinerary;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
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

    public void addItinerary(Itinerary itinerary) {
        this.itineraryRepository.save(itinerary);
    }

    public void addItineraryStrings(String itineraryName, String itineraryDestination, String itineraryDuration) {
        int durationInt;

        try {
            durationInt = Integer.parseInt(itineraryDuration);
        } catch (NumberFormatException exception) {
            System.out.println(exception);
            durationInt = 0;
        }

        Itinerary itinerary = new Itinerary(itineraryName, itineraryDestination, durationInt);
        this.itineraryRepository.save(itinerary);
    }
}
