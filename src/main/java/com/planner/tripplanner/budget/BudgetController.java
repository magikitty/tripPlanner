package com.planner.tripplanner.budget;

import com.planner.tripplanner.itinerary.Itinerary;
import com.planner.tripplanner.itinerary.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BudgetController {
    @Autowired
    BudgetService budgetService;

    @Autowired
    ItineraryService itineraryService;

    @GetMapping("/budget{idBudget}")
    public String getBudgetInfo(@PathVariable("idBudget") Long idBudget, Model model, @RequestParam String idItinerary) {
        Budget budget = budgetService.getBudgetById(idBudget);
        Itinerary itinerary = itineraryService.getItineraryById(Long.valueOf(idItinerary));

        Double budgetCulture = budget.calcCategoryBudget(itinerary, "Culture");
        Double budgetEat = budget.calcCategoryBudget(itinerary, "Eating and drinking");
        Double budgetNature = budget.calcCategoryBudget(itinerary, "Nature");
        Double budgetShopping = budget.calcCategoryBudget(itinerary, "Shopping");
        Double budgetOther = budget.calcCategoryBudget(itinerary, "Other activities");

        model.addAttribute("itinerary", itinerary);
        model.addAttribute("budget", budget);
        model.addAttribute("budgetCulture", budgetCulture);
        model.addAttribute("budgetEat", budgetEat);
        model.addAttribute("budgetNature", budgetNature);
        model.addAttribute("budgetShopping", budgetShopping);
        model.addAttribute("budgetOther", budgetOther);
        return "budgetPage";
    }
}
