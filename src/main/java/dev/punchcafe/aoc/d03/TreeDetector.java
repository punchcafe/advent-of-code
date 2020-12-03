package dev.punchcafe.aoc.d03;

public class TreeDetector {
    public static int numberOfTrees(final Slope slope, int[] startCord, int[] gradient){
        if(startCord.length != 2 || gradient.length != 2){
            throw new IllegalArgumentException();
        }
        if(gradient[1] == 0){
            throw new IllegalArgumentException("WILL RUN FOREVER");
        }
        int numberOfTrees = 0;
        int[] currentCord = startCord;
        try{
            while (true){
                if(slope.isTreeAt(currentCord[0], currentCord[1])){
                    numberOfTrees++;
                }
                currentCord[0] += gradient[0];
                currentCord[1] += gradient[1];
            }
        } catch (IndexOutOfBoundsException ex){
            return numberOfTrees;
        }
    }
}
