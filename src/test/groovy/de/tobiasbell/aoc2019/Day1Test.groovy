package de.tobiasbell.aoc2019

import spock.lang.Specification
import spock.lang.Unroll

import static de.tobiasbell.aoc2019.Day1.calculateFuel
import static de.tobiasbell.aoc2019.Day1.calculateFuelExtended

class Day1Test extends Specification {

    @Unroll
    def "Needed fuel for mass #mass is #expectedFuel"(long mass, long expectedFuel) {
        expect:
        calculateFuel(mass) == expectedFuel

        where:
        mass   | expectedFuel
        12     | 2
        14     | 2
        1969   | 654
        100756 | 33583
    }

    @Unroll
    def "Fuel extended for mass #mass is #fuel"(long mass, long fuel) {
        expect:
        calculateFuelExtended(mass) == fuel

        where:
        mass   | fuel
        14     | 2
        1969   | 966
        100756 | 50346
    }

    def "Solve part 1"() {
        given:
        def solver = new Day1()
        def input = getClass().getResourceAsStream("/day1.txt")

        expect:
        solver.part1(input) == 3228475

    }

    def "Solve part 2"() {
        given:
        def solver = new Day1()
        def input = getClass().getResourceAsStream("/day1.txt")

        expect:
        solver.part2(input) == 4839845
    }
}
