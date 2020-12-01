package dev.punchcafe.aoc.d01;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class ReportRepairTest {

    private ReportRepair reportRepair;

    @Test
    void shouldWork() {
        reportRepair = new ReportRepair(new int[] {1, 2, 3, 4, 5}, 9);
        final var result = reportRepair.calculate();
        System.out.println(result);
    }

    @Test
    void getSolution() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSetArray = Files.lines(Path.of(userDirectory + "/src/test/resources/d01a/input.txt"))
                .mapToInt(Integer::parseInt)
                .toArray();
        reportRepair = new ReportRepair(problemSetArray, 2020);
        final var result = reportRepair.calculate();
        System.out.println(result);
    }
}
