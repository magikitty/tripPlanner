package com.planner.tripplanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activity {
    private String name;
    private String category;
    private String status;  // done or to-do
    private Double duration;    // in hours
    private Double cost;
}
