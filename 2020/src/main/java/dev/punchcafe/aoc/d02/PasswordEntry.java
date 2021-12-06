package dev.punchcafe.aoc.d02;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PasswordEntry {
    private PasswordPolicy policy;
    private String password;
}
