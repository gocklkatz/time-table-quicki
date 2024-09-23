package io.gocklkatz.tsp;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Visit {
    private Location location;

    @PlanningVariable(valueRangeProviderRefs = "locationRange")
    private Visit previousVisit;

    public Visit() {
    }

    public Visit(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Visit getPreviousVisit() {
        return previousVisit;
    }

    public void setPreviousVisit(Visit previousVisit) {
        this.previousVisit = previousVisit;
    }

    public int getDistanceFromPrevious() {
        if (previousVisit == null) {
            return 0;
        }
        return (int) (previousVisit.getLocation().distanceTo(location));
    }
}