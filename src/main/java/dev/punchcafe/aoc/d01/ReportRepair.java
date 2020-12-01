package dev.punchcafe.aoc.d01;

import java.util.Arrays;
import java.util.Optional;

public class ReportRepair {

    private int[] internalSortedArray;

    public ReportRepair(int[] problemSet) {
        // If memory were no object, this could be solved with a boolean map of int value to whether it exists or not, for looking up.
        this.internalSortedArray = Arrays.stream(problemSet).sorted().toArray();
    }

    public Optional<Integer> calculateThreeBodyProblem(int targetNumber) {
        for (int i = 0; i < this.internalSortedArray.length; i++) {
            // Another optimisation is to contract the array as you go through, as you know any passed elements wont be able to pair with anythign
            int number = this.internalSortedArray[i];
            if (number > targetNumber) {
                continue;
            }
            int totalRemainder = targetNumber - number;

            final var entityResult = this.calculateTwoBodyProblem(this.internalSortedArray,
                                                                  totalRemainder,
                                                                  i,
                                                                  this.internalSortedArray.length - 1);
            if (entityResult.isPresent()) {
                return Optional.of(entityResult.get() * number);
            }
        }
        return Optional.empty();
    }

    public Optional<Integer> calculateTwoBodyProblem(int targetNumber) {
        return calculateTwoBodyProblem(this.internalSortedArray, targetNumber, 0, this.internalSortedArray.length - 1);
    }

    public Optional<Integer> calculateTwoBodyProblem(int[] problemSet, int targetNumber, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            // Another optimisation is to contract the array as you go through, as you know any passed elements wont be able to pair with anythign
            int number = problemSet[i];
            if (number > targetNumber) {
                continue;
            }
            int targetPair = targetNumber - number;
            // We can slice the array by starting from i, since we know all up to that number have been checked,
            // meaning by symmetry we can rule them out of being suitable pairs for future numbers, thus removing the need
            // to include them in is number present
            if (isNumberPresent(targetPair, problemSet, i, problemSet.length - 1)) {
                return Optional.of(number * targetPair);
            }
            ;
        }
        return Optional.empty();
    }

    private boolean isNumberPresent(int number, final int[] sortedProblemSet, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return sortedProblemSet[beginIndex] == number;
        }
        final var leftHandSideIndex = (beginIndex + endIndex) / 2;
        final var rightHandSideIndex = leftHandSideIndex + 1;
        final var isLeftHandSide = number <= sortedProblemSet[leftHandSideIndex];
        if (isLeftHandSide) {
            return isNumberPresent(number, sortedProblemSet, beginIndex, leftHandSideIndex);
        } else {
            return isNumberPresent(number, sortedProblemSet, rightHandSideIndex, endIndex);
        }
    }

    ;
}
