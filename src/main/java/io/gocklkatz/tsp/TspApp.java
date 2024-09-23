package io.gocklkatz.tsp;
import ai.timefold.solver.core.api.solver.Solver;
import ai.timefold.solver.core.api.solver.SolverFactory;
import ai.timefold.solver.core.config.solver.SolverConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class TspApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(TspApp.class);

    public static void main(String[] args) {
        SolverConfig solverConfig = new SolverConfig()
                .withSolutionClass(TspSolution.class)
                .withEntityClasses(Visit.class)
                .withConstraintProviderClass(TspConstraintProvider.class);
        SolverFactory<TspSolution> solverFactory = SolverFactory.create(solverConfig);
        Solver<TspSolution> solver = solverFactory.buildSolver();

        TspSolution problem = generateDemoData();
        TspSolution solution = solver.solve(problem);

        printSolution(solution);
    }

    private static TspSolution generateDemoData() {
        List<Location> locations = Arrays.asList(
                new Location("A", 0, 0),
                new Location("B", 1, 0),
                new Location("C", 0, 1),
                new Location("D", 1, 1)
        );

        List<Visit> visits = Arrays.asList(
                new Visit(locations.get(0)),
                new Visit(locations.get(1)),
                new Visit(locations.get(2)),
                new Visit(locations.get(3))
        );

        return new TspSolution(locations, visits);
    }

    private static void printSolution(TspSolution solution) {
        for (Visit visit : solution.getVisitList()) {
            LOGGER.info("Visit: " + visit.getLocation().getName());
        }
    }
}