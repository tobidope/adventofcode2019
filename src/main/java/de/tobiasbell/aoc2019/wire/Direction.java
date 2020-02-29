package de.tobiasbell.aoc2019.wire;

import java.util.Arrays;

public enum Direction {
    RIGHT("R", new Coordinate(1, 0)),
    LEFT("L", new Coordinate(-1, 0)),
    UP("U", new Coordinate(0, 1)),
    DOWN("D", new Coordinate(0, -1));

    private final String direction;
    private final Coordinate coordinate;

    Direction(String direction, Coordinate coordinate) {
        this.direction = direction;
        this.coordinate = coordinate;
    }

    static Direction of(String direction) {
        return Arrays.stream(values())
                .filter(d -> d.getDirection().equals(direction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid direction " + direction));
    }

    public String getDirection() {
        return direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
