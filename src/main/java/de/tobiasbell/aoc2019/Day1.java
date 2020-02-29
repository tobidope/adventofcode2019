package de.tobiasbell.aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

public class Day1 {

    public static long calculateFuel(long mass) {
        return mass / 3 - 2;
    }

    public static long calculateFuelExtended(long mass) {
        return LongStream
                .iterate(calculateFuel(mass), fuel -> fuel > 0, Day1::calculateFuel)
                .sum();
    }

    public long part1(InputStream input) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines()
                    .mapToLong(Long::parseLong)
                    .map(Day1::calculateFuel)
                    .sum();
        }
    }

    public long part2(InputStream input) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines()
                    .mapToLong(Long::parseLong)
                    .map(Day1::calculateFuelExtended)
                    .sum();
        }
    }
}
