package dev.punchcafe.aoc.d02;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringParser {

    private static Pattern REGEX_PATTERN = Pattern.compile("(\\d+)-(\\d+) ([^ :])+: ([^ ]+)$");

    public static long totalIncorrectPasswords(final Stream<String> input){
        return input.map(StringParser::parseEntry)
                .filter(PasswordValidator::isValid)
                .count();
    }

    private static PasswordValidator parseEntry(final String fileLine){
        final var matcher = REGEX_PATTERN.matcher(fileLine);
        matcher.find();
        final int min = Integer.parseInt(matcher.group(1));
        final int max = Integer.parseInt(matcher.group(2));
        final var character = matcher.group(3).charAt(0);
        final var password = matcher.group(4);

        final var policy = PasswordPolicy.builder()
                .minAllowedInstances(min)
                .maxAllowedInstances(max)
                .restrictedCharacter(character)
                .build();

        return PasswordValidator.builder()
                .policy(policy)
                .password(password)
                .build();
    }

}
