package de.tobiasbell.aoc2019.intcode

import spock.lang.Specification
import spock.lang.Unroll

class ProgramTest extends Specification {

    @Unroll("programm #program gives #result")
    def "Evaluate programm"(def program, def result) {
        given:
        def p = Program.fromString(program)

        expect:
        p.evaluate() == result

        where:
        program               | result
        "1,0,0,0,99"          | [2, 0, 0, 0, 99]
        "2,3,0,3,99"          | [2, 3, 0, 6, 99]
        "2,4,4,5,99,0"        | [2, 4, 4, 5, 99, 9801]
        "1,1,1,4,99,5,6,0,99" | [30, 1, 1, 4, 2, 5, 6, 0, 99]

    }
}
