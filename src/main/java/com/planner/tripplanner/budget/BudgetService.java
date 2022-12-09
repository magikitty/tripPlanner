package com.planner.tripplanner.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public void addBudget(Budget budget) {
        this.budgetRepository.save(budget);
    }
}
