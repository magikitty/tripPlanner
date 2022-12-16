package com.planner.tripplanner.itinerary;

import com.planner.tripplanner.activity.Activity;
import com.planner.tripplanner.budget.Budget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Itinerary extends AbstractPersistable<Long> {
    @Id
    private Long id;
    private String name;
    private String destination;
    private int duration;   // number of days
    // One itinerary can have many activities - one-to-many mapping in database
    @OneToMany()
    private List<Activity> activities;
    @OneToOne
    private Budget budget;

    public Itinerary(String name, String destination, int duration, Budget budget) {
        this.name = name;
        this.destination = destination;
        this.duration = duration;
        this.activities = new ArrayList<>();
        this.budget = budget;
        this.budget.setIdItinerary(this.id);
    }

    public Itinerary(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }

    public Double getBudgetUsed() {
        this.budget.calculateAmountUsed(this.activities);
        return this.budget.getAmountUsed();
    }

    public Double getBudgetLeft() {
        this.budget.calculateAmountLeft(this.activities);
        return this.budget.getAmountLeft();
    }
}
