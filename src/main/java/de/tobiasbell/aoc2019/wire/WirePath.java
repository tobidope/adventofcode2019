package de.tobiasbell.aoc2019.wire;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WirePath {
    private final Direction direction;
    private final int steps;

    public WirePath(Direction direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public static WirePath of(String path) {
        Direction d = Direction.of(path.substring(0, 1));
        int s = Integer.parseInt(path.substring(1));
        return new WirePath(d, s);
    }

    public static List<WirePath> pathList(String path) {
        return Arrays.stream(path.split(",")).map(WirePath::of).collect(toList());
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }
}
