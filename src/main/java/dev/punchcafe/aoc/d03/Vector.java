package dev.punchcafe.aoc.d03;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Vector {

    private int x;
    private int y;

    public Vector plus(final Vector operand) {
        return new Vector(this.x + operand.getX(), this.y + operand.getY());
    }
}
