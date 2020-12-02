package dev.punchcafe.aoc.d02;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PasswordPolicy {
    private char character;
    private int leftNumber;
    private int rightNumber;
}
