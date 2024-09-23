package io.gocklkatz.tsp;

import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.simple.SimpleScore;

import java.util.List;

@PlanningSolution
public class TspSolution {
    @ProblemFactCollectionProperty
    private List<Location> locationList;

    @PlanningEntityCollectionProperty
    private List<Visit> visitList;

    @PlanningScore
    private SimpleScore score;

    public TspSolution() {
    }

    public TspSolution(List<Location> locationList, List<Visit> visitList) {
        this.locationList = locationList;
        this.visitList = visitList;
    }

    @ValueRangeProvider(id = "locationRange")
    public List<Visit> getLocationRange() {
        return visitList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public SimpleScore getScore() {
        return score;
    }

    public void setScore(SimpleScore score) {
        this.score = score;
    }
}
