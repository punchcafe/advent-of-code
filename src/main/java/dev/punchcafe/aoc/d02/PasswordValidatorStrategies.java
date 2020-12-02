package dev.punchcafe.aoc.d02;

public class PasswordValidatorStrategies {

    public static Boolean isValidOTCASPassword(final PasswordEntry entry) {
        final char leftIndexChar = entry.getPassword().charAt(entry.getPolicy().getLeftNumber() - 1);
        final char rightIndexChar = entry.getPassword().charAt(entry.getPolicy().getRightNumber() - 1);
        if(leftIndexChar == entry.getPolicy().getCharacter() && rightIndexChar == entry.getPolicy().getCharacter()){
            return false;
        }
        return leftIndexChar == entry.getPolicy().getCharacter() || rightIndexChar == entry.getPolicy().getCharacter();
    }
    public static boolean isValidSledRentalPassword(final PasswordEntry entry) {
        int count = 0;
        for (char character : entry.getPassword().toCharArray()) {
            if (character == entry.getPolicy().getCharacter()) {
                count++;
                if (count > entry.getPolicy().getRightNumber()) {
                    return false;
                }
            }
        }
        return count >= entry.getPolicy().getLeftNumber() && count <= entry.getPolicy().getRightNumber();
    }

    ;
}
