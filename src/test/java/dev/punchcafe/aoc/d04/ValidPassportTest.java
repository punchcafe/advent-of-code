package dev.punchcafe.aoc.d04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import dev.punchcafe.aoc.d03.Slope;
import dev.punchcafe.aoc.d03.TreeDetector;
import dev.punchcafe.aoc.d03.Vector;
import org.junit.jupiter.api.Test;

public class ValidPassportTest {

    @Test
    void getSolutionForFirstProblem() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSetPath = userDirectory + "/src/test/resources/d04/input.txt";
        final var result = ValidPassports.validPassports(problemSetPath);
        assertEquals(result, 5);
    }
}
