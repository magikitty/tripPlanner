package com.planner.tripplanner.itinerary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Itinerary extends AbstractPersistable<Long> {
    @Id
    private Long id;
    private String name;
    private int duration;   // number of days

    public Itinerary(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}
