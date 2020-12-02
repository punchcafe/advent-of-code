package dev.punchcafe.aoc.d02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class SledRentalPasswordValidatorTest {

    @Test
    void getSolutionForSledRental() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSet = Files.lines(Path.of(userDirectory + "/src/test/resources/d02/passwords.txt"));
        assertEquals(StringParser.totalIncorrectPasswords(problemSet, PasswordValidatorStrategies::isValidSledRentalPassword), 517);
    }

    @Test
    void getSolutionForOTCAS() throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        final var problemSet = Files.lines(Path.of(userDirectory + "/src/test/resources/d02/passwords.txt"));
        assertEquals(StringParser.totalIncorrectPasswords(problemSet, PasswordValidatorStrategies::isValidOTCASPassword), 284);
    }
}
