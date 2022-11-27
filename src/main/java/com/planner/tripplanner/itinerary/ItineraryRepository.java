package com.planner.tripplanner.itinerary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    @Override
    ArrayList<Itinerary> findAll();
}
