package com.planner.tripplanner.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BudgetController {

    @Autowired
    BudgetService budgetService;

    @GetMapping("/budget{idBudget}")
    public String getBudgetInfo(@PathVariable("idBudget") Long idBudget, Model model) {
        Budget budget = budgetService.getBudgetById(idBudget);
        model.addAttribute(budget);
        return "budgetPage";
    }
}
