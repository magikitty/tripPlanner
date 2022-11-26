package com.planner.tripplanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activity extends AbstractPersistable<Long> {
    // Mark id as primary key
    @Id
    private Long id;
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
    }

    public Activity(String name, String category, String status, Double duration, Double cost) {
        this.name = name;
        this.category = category;
        this.status = status;
        this.duration = duration;
        this.cost = cost;
    }
}
