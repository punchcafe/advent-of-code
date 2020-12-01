package dev.punchcafe.aoc.d01;

import java.util.Arrays;
import java.util.Optional;

public class ReportRepair {

    private int[] sortedArray;
    private int targetNumber;

    public ReportRepair(int[] problemSet, int targetNumber){
        // If memory were no object, this could be solved with a boolean map of int value to whether it exists or not, for looking up.
        this.sortedArray = Arrays.stream(problemSet).sorted().toArray();
        this.targetNumber = targetNumber;
    }

    public Optional<Integer> calculate(){
        for(int i = 0; i < sortedArray.length; i++){
            // Another optimisation is to contract the array as you go through, as you know any passed elements wont be able to pair with anythign
            int number = sortedArray[i];
            if(number > targetNumber){
                continue;
            }
            int targetPair = targetNumber - number;
            // We can slice the array by starting from i, since we know all up to that number have been checked,
            // meaning by symmetry we can rule them out of being suitable pairs for future numbers, thus removing the need
            // to include them in is number present
            if(isNumberPresent(targetPair, i, sortedArray.length - 1)){
                return Optional.of(number * targetPair);
            };
        }
        return Optional.empty();
    }

    private boolean isNumberPresent(int number, int beginIndex, int endIndex){
        if(beginIndex == endIndex){
            return sortedArray[beginIndex] == number;
        }
        final var leftHandSideIndex = (beginIndex + endIndex) / 2;
        final var rightHandSideIndex = leftHandSideIndex + 1;
        final var isLeftHandSide = number <= sortedArray[leftHandSideIndex];
        if(isLeftHandSide){
            return isNumberPresent(number, beginIndex, leftHandSideIndex);
        } else {
            return isNumberPresent(number, rightHandSideIndex, endIndex);
        }
    };
}
