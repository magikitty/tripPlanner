package com.planner.tripplanner.budget;

import com.planner.tripplanner.activity.Activity;
import com.planner.tripplanner.itinerary.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Data
public class Budget extends AbstractPersistable<Long> {
    @Id
    private Long id;

    private Double totalBudget;
    private Double amountUsed;
    private Double amountLeft;
    private Long idItinerary;

    public Budget() {
        this.totalBudget = 0.0;
        this.amountLeft = 0.0;
        this.amountUsed = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void calculateAmountUsed(List<Activity> activities) {
        for (Activity activity : activities) {
            this.amountUsed += activity.getCost();
        }
    }

    public void calculateAmountLeft(List<Activity> activities) {
        calculateAmountUsed(activities);
        this.amountLeft = this.totalBudget - this.amountUsed;
    }

    // Calculate total amount budgeted for activities in each category
    public Double calcCategoryBudget(Itinerary itinerary, String category) {
        Double total = 0.0;
        List<Activity> activities = itinerary.getActivities();

        for (Activity activity : activities) {
            if (Objects.equals(activity.getCategory(), category)) {
                total += activity.getCost();
            }
        }

        return total;
    }
}
