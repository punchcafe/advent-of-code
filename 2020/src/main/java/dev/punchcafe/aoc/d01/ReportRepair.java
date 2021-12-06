package dev.punchcafe.aoc.d01;

import java.util.Arrays;
import java.util.Optional;

public class ReportRepair {

    private int[] internalSortedArray;

    public ReportRepair(int[] problemSet) {
        this.internalSortedArray = Arrays.stream(problemSet).sorted().toArray();
    }

    public Optional<Integer> calculateThreeBodyProblem(int targetNumber) {
        for (int i = 0; i < this.internalSortedArray.length; i++) {
            // Another optimisation is to contract the array as you go through,
            // as you know any passed elements won't be able to pair with anything
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

    private Optional<Integer> calculateTwoBodyProblem(int[] sortedArray, int targetNumber, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            // Another optimisation is to contract the array as you go through, as you know any passed elements wont be able to pair with anythign
            int number = sortedArray[i];
            if (number > targetNumber) {
                continue;
            }
            int targetPair = targetNumber - number;
            // We can slice the array by starting from i, since we know all up to that number have been checked,
            // meaning by symmetry we can rule them out of being suitable pairs for future numbers, thus removing the need
            // to include them in is number present
            if (isNumberPresent(targetPair, sortedArray, i, sortedArray.length - 1)) {
                return Optional.of(number * targetPair);
            }
        }
        return Optional.empty();
    }

    private boolean isNumberPresent(int number, final int[] sortedArray, int beginIndex, int endIndex) {
        // If memory is no issue, this could be solved with a Map<Integer, Boolean> of int value to whether it exists or not.
        if (beginIndex == endIndex) {
            return sortedArray[beginIndex] == number;
        }
        final var leftHandSideIndex = (beginIndex + endIndex) / 2;
        final var rightHandSideIndex = leftHandSideIndex + 1;
        final var isLeftHandSide = number <= sortedArray[leftHandSideIndex];
        if (isLeftHandSide) {
            return isNumberPresent(number, sortedArray, beginIndex, leftHandSideIndex);
        } else {
            return isNumberPresent(number, sortedArray, rightHandSideIndex, endIndex);
        }
    }
}
