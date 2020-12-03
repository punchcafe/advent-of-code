package dev.punchcafe.aoc.d03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import dev.punchcafe.aoc.d02.PasswordValidatorStrategies;
import dev.punchcafe.aoc.d02.StringParser;
import org.junit.jupiter.api.Test;

public class TreeDetectorTest {

    @Test
    void getSolutionForSledRental() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSet = Files.lines(Path.of(userDirectory + "/src/test/resources/d03/input.txt"));
        final var slope = Slope.buildFromTextStream(problemSet);
        assertEquals(TreeDetector.numberOfTrees(slope, new int[]{0,0}, new int[]{3,1}), 187);
    }
}
