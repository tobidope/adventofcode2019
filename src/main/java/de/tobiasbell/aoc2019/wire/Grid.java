package de.tobiasbell.aoc2019.wire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
    private final Map<Coordinate, Cell> grid = new HashMap<>();

    public List<Coordinate> findIntersections(List<WirePath> path1, List<WirePath> path2) {
        find(path1, Cell.WIRE1);
        return find(path2, Cell.WIRE2);
    }

    private List<Coordinate> find(List<WirePath> wirePaths, Cell cell) {
        Coordinate currentPosition = new Coordinate(0, 0);
        List<Coordinate> intersections = new ArrayList<>();

        for (var p : wirePaths) {
            Direction d = p.getDirection();
            for (int i = 0; i < p.getSteps(); i++) {
                currentPosition = currentPosition.add(d.getCoordinate());
                Cell currentCell = grid.getOrDefault(currentPosition, Cell.EMPTY);
                if (currentCell == Cell.EMPTY) {
                    grid.put(currentPosition, cell);
                } else {
                    intersections.add(currentPosition);
                }
            }
        }

        return intersections;
    }
}
