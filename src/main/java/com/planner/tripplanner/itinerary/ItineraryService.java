package com.planner.tripplanner.itinerary;

import com.planner.tripplanner.activity.Activity;
import com.planner.tripplanner.budget.Budget;
import com.planner.tripplanner.budget.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItineraryService {
    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private BudgetService budgetService;

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

    public void addItineraryStrings(String itineraryName, String itineraryDestination, String itineraryDuration, String itineraryBudget) {
        int durationInt;

        try {
            durationInt = Integer.parseInt(itineraryDuration);
        } catch (NumberFormatException exception) {
            System.out.println(exception);
            durationInt = 0;
        }

        Budget budget = new Budget();
        budget.setTotalBudget(Double.valueOf(itineraryBudget));
        this.budgetService.addBudget(budget);

        Itinerary itinerary = new Itinerary(itineraryName, itineraryDestination, durationInt, budget);
        this.itineraryRepository.save(itinerary);
    }

    public void addActivityToItinerary(String itineraryId, Activity activity) {
        Optional<Itinerary> itineraryOptional = this.itineraryRepository.findById(Long.parseLong(itineraryId));
        Itinerary itinerary = itineraryOptional.get();
        itinerary.addActivity(activity);
        this.itineraryRepository.save(itinerary);
    }
}
