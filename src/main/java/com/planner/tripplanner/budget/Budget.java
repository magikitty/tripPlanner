package com.planner.tripplanner.budget;

import com.planner.tripplanner.activity.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Budget extends AbstractPersistable<Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long id;

    @Id
    private Long id;

    private Double totalBudget;
    private Double amountUsed;
    private Double amountLeft;

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
}
