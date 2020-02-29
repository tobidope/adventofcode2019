package de.tobiasbell.aoc2019

import spock.lang.Specification

import static de.tobiasbell.aoc2019.Day2.solve_part1
import static de.tobiasbell.aoc2019.Day2.solve_part2

class Day2Test extends Specification {

    def "Solve part 1"() {
        given:
        def input = getClass().getResourceAsStream("/day2.txt")
        expect:
        solve_part1(input) == 3562672
    }

    def "Solve part 2"() {
        given:
        def input = getClass().getResourceAsStream("/day2.txt")
        expect:
        solve_part2(input) == 8250
    }
}
