package de.tobiasbell.aoc2019;

import de.tobiasbell.aoc2019.intcode.Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Day2 {

    public static int solve_part1(InputStream stream) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(stream))) {
            String s = reader.lines().collect(Collectors.joining());
            return Program.fromString(s).evaluateWithParameter(12, 2).get(0);
        }
    }

    public static int solve_part2(InputStream stream) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(stream))) {
            String s = reader.lines().collect(Collectors.joining());
            Program program = Program.fromString(s);
            for (int noun = 0; noun < 100; noun++) {
                for (int verb = 0; verb < 100; verb++) {
                    int result = program.evaluateWithParameter(noun, verb).get(0);
                    if (result == 19690720) {
                        return 100 * noun + verb;
                    }
                }
            }
        }
        return -1;
    }
}
