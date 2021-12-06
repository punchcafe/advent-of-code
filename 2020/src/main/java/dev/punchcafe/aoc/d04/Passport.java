package dev.punchcafe.aoc.d04;

import java.util.Objects;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Passport {

    @DataCode("byr")
    private String birthYear;
    @DataCode("iyr")
    private String issueYear;
    @DataCode("eyr")
    private String expirationYear;
    @DataCode("hgt")
    private String height;
    @DataCode("hcl")
    private String hairColor;
    @DataCode("pid")
    private String passportId;
    @DataCode("cid")
    private String countryId;
    @DataCode("ecl")
    private String eyeColor;

    public boolean isValidNPC() {
        return Stream.of(this.birthYear,
                         this.issueYear,
                         this.expirationYear,
                         this.height,
                         this.hairColor,
                         this.passportId,
                         this.eyeColor)
                .noneMatch(Objects::isNull);
    }


}
