package dev.punchcafe.aoc.d03;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Slope {

    char[][] internalArray;
    int width;
    int height;

    public static Slope buildFromTextStream(final Stream<String> textStream) {
        final List<String> allLines = textStream.collect(toList());
        final int width = allLines.get(0).length();
        final int height = allLines.size();
        final char[][] internalArray = new char[height][width];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                internalArray[j][i] = allLines.get(j).charAt(i);
            }
        }
        return new Slope(internalArray, internalArray[0].length, internalArray.length);
    }

    public boolean isTreeAt(final Vector position) {
        if (position.getY() < 0 || position.getY() >= height) {
            throw new IndexOutOfBoundsException();
        }
        return internalArray[position.getY()][adjustXCoordinate(position.getX())] == '#';
    }

    private int adjustXCoordinate(final int x) {
        return x % width;
    }
}
