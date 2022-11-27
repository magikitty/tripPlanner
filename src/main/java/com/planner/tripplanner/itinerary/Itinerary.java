package com.planner.tripplanner.itinerary;

import com.planner.tripplanner.activity.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Itinerary {
    private Long id;
    private int name;
    private int duration;   // number of days
    private ArrayList<Activity> activities;
}
