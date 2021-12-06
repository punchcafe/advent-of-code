package dev.punchcafe.aoc.d03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import dev.punchcafe.aoc.d02.PasswordValidatorStrategies;
import dev.punchcafe.aoc.d02.StringParser;
import org.junit.jupiter.api.Test;

public class TreeDetectorTest {

    @Test
    void getSolutionForFirstProblem() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSet = Files.lines(Path.of(userDirectory + "/src/test/resources/d03/input.txt"));
        final var slope = Slope.buildFromTextStream(problemSet);
        assertEquals(TreeDetector.numberOfTrees(slope, new Vector(0, 0), new Vector(3, 1)), 187);
    }

    @Test
    void getSolutionForSecondProblem() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSet = Files.lines(Path.of(userDirectory + "/src/test/resources/d03/input.txt"));
        final var slope = Slope.buildFromTextStream(problemSet);
        final Stream<Vector> allGradients = Stream.of(new Vector(1, 1),
                                                      new Vector(3, 1),
                                                      new Vector(5, 1),
                                                      new Vector(7, 1),
                                                      new Vector(1, 2));
        assertEquals(4723283400L,
                     TreeDetector.productOfNumberOfTreesForOriginAndSlopes(slope, new Vector(0, 0), allGradients));
    }
}
