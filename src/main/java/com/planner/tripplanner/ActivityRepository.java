package com.planner.tripplanner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // Override default behaviour and return array list
    @Override
    ArrayList<Activity> findAll();
}
