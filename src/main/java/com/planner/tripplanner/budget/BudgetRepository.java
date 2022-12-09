package com.planner.tripplanner.budget;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    @Override
    ArrayList<Budget> findAll();
}
