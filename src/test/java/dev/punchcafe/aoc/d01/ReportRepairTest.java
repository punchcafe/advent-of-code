package dev.punchcafe.aoc.d01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class ReportRepairTest {

    private ReportRepair reportRepair;

    @Test
    void shouldReturnEmptyIfNoSolutionToTwoBodyProblem() {
        reportRepair = new ReportRepair(new int[] {1, 2, 3, 4, 5});
        final var result = reportRepair.calculateTwoBodyProblem(30);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyIfNoSolutionToThreeBodyProblem() {
        reportRepair = new ReportRepair(new int[] {1, 2, 3, 4, 5});
        final var result = reportRepair.calculateThreeBodyProblem(30);
        assertTrue(result.isEmpty());
    }

    @Test
    void getSolutionTwoBodySolution() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSetArray = Files.lines(Path.of(userDirectory + "/src/test/resources/d01a/input.txt"))
                .mapToInt(Integer::parseInt)
                .toArray();
        reportRepair = new ReportRepair(problemSetArray);
        final var result = reportRepair.calculateTwoBodyProblem(2020);
        assertEquals(result.get(), 319531);
    }

    @Test
    void getSolutionThreeBodySolution() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSetArray = Files.lines(Path.of(userDirectory + "/src/test/resources/d01a/input.txt"))
                .mapToInt(Integer::parseInt)
                .toArray();
        reportRepair = new ReportRepair(problemSetArray);
        final var result = reportRepair.calculateThreeBodyProblem(2020);
        assertEquals(result.get(), 244300320);
    }
}
