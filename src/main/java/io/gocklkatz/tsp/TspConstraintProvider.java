package io.gocklkatz.tsp;

import ai.timefold.solver.core.api.score.buildin.simple.SimpleScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;

public class TspConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                distanceConstraint(constraintFactory)
        };
    }

    private Constraint distanceConstraint(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Visit.class)
                .penalize("Distance from previous", SimpleScore.ONE, Visit::getDistanceFromPrevious);
    }
}
