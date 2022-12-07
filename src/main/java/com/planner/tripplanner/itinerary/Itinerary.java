package com.planner.tripplanner.itinerary;

import com.planner.tripplanner.activity.Activity;
import com.planner.tripplanner.activity.ActivityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
//    @OneToMany(mappedBy = "itinerary")
//    private ArrayList<Activity> activities;
    @OneToMany()
    private List<Activity> activities;

    public Itinerary(String name, String destination, int duration) {
        this.name = name;
        this.destination = destination;
        this.duration = duration;
        this.activities = new ArrayList<Activity>();
    }

    public Itinerary(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.activities = new ArrayList<Activity>();
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
}
