package dev.punchcafe.aoc.d04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ValidPassports {
    public static long validPassports(final String inputDataPath) throws IOException {
        final BufferedReader fileReader = new BufferedReader(new FileReader(inputDataPath));
        return PassportConverter.convertData(fileReader)
                .filter(Passport::isValidNPC)
                .count();
    }
}
