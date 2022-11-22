package com.planner.tripplanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlannerController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
