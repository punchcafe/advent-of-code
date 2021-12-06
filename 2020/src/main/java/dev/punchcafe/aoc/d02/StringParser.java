package dev.punchcafe.aoc.d02;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringParser {

    private static Pattern REGEX_PATTERN = Pattern.compile("(\\d+)-(\\d+) ([^ :])+: ([^ ]+)$");

    public static long totalIncorrectPasswords(final Stream<String> input,
                                               final Predicate<PasswordEntry> validationStrategy){
        return input.map(StringParser::parseEntry)
                .filter(validationStrategy)
                .count();
    }

    private static PasswordEntry parseEntry(final String fileLine){
        final var matcher = REGEX_PATTERN.matcher(fileLine);
        matcher.find();
        final int left = Integer.parseInt(matcher.group(1));
        final int right = Integer.parseInt(matcher.group(2));
        final var character = matcher.group(3).charAt(0);
        final var password = matcher.group(4);

        final var policy = PasswordPolicy.builder()
                .leftNumber(left)
                .rightNumber(right)
                .character(character)
                .build();

        return PasswordEntry.builder()
                .policy(policy)
                .password(password)
                .build();
    }

}
