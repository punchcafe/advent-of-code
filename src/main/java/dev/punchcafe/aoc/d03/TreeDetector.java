package dev.punchcafe.aoc.d03;

import java.util.stream.Stream;

public class TreeDetector {

    public static long numberOfTrees(final Slope slope, final Vector startCord, final Vector gradient) {
        if (gradient.getY() == 0) {
            throw new IllegalArgumentException("WILL RUN FOREVER");
        }
        long numberOfTrees = 0;
        Vector currentCord = startCord;
        try {
            while (true) {
                if (slope.isTreeAt(currentCord)) {
                    numberOfTrees++;
                }
                currentCord = currentCord.plus(gradient);
            }
        } catch (IndexOutOfBoundsException ex) {
            return numberOfTrees;
        }
    }

    public static long productOfNumberOfTreesForOriginAndSlopes(final Slope slope, final Vector origin, final Stream<Vector> gradients) {
        return gradients
                .mapToLong(grad -> TreeDetector.numberOfTrees(slope, origin, grad))
                .reduce((o, x) -> o * x)
                .getAsLong();
    }
}
