package com.planner.tripplanner.budget;

import com.planner.tripplanner.activity.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double totalBudget;
    private Double amountUsed;
    private Double amountLeft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void calculateAmountUsed(ArrayList<Activity> activities) {
        this.amountUsed = 0.0;
        for (Activity activity : activities) {
            this.amountUsed += activity.getCost();
        }
    }

    public void calculateAmountLeft(ArrayList<Activity> activities) {
        calculateAmountUsed(activities);
        this.amountLeft = this.totalBudget - this.amountUsed;
    }
}
