package com.planner.tripplanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activity extends AbstractPersistable<Long> {
    private String name;
    private String category;
    private String status;  // done or to-do
    private Double duration;    // in hours
    private Double cost;

    // Constructor with default values
    public Activity(String name) {
        this.name = name;
        this.category = "activity";
        this.status = "to-do";
        this.duration = 1.0;
        this.cost = 0.0;
        //this.id = UUID.randomUUID().getMostSignificantBits();
    }
}
