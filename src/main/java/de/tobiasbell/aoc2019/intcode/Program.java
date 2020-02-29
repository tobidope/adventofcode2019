package de.tobiasbell.aoc2019.intcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    private final List<Integer> program;

    public Program(List<Integer> program) {
        this.program = program;
    }

    public static Program fromString(String input) {
        List<Integer> program = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Program(program);
    }

    public List<Integer> evaluateWithParameter(int parameter1, int parameter2) {
        var memory = new ArrayList<>(program);
        memory.set(1, parameter1);
        memory.set(2, parameter2);
        return evaluateProgram(memory);
    }

    public List<Integer> evaluate() {
        return evaluateProgram(new ArrayList<>(program));
    }

    private List<Integer> evaluateProgram(List<Integer> memory) {
        int instructionPointer = 0;
        OpCode opCode = OpCode.of(memory.get(instructionPointer));
        while (instructionPointer < memory.size() && opCode != OpCode.EXIT) {
            switch (opCode) {
                case ADD: {
                    var adress1 = memory.get(instructionPointer + 1);
                    var adress2 = memory.get(instructionPointer + 2);
                    var storeAdress = memory.get(instructionPointer + 3);
                    int sum = memory.get(adress1) + memory.get(adress2);
                    memory.set(storeAdress, sum);
                    instructionPointer += 4;
                    break;
                }
                case MULTIPLY: {
                    var adress1 = memory.get(instructionPointer + 1);
                    var adress2 = memory.get(instructionPointer + 2);
                    var storeAdress = memory.get(instructionPointer + 3);
                    int product = memory.get(adress1) * memory.get(adress2);
                    memory.set(storeAdress, product);
                    instructionPointer += 4;
                    break;
                }
                case EXIT:
                    break;
            }
            opCode = OpCode.of(memory.get(instructionPointer));
        }
        return memory;
    }

    private enum OpCode {
        ADD(1), MULTIPLY(2), EXIT(99);

        private final int opcode;

        OpCode(int opcode) {
            this.opcode = opcode;
        }

        public static OpCode of(int opcode) {
            return Arrays.stream(OpCode.values())
                    .filter(code -> code.opcode == opcode)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown opcode " + opcode));
        }
    }
}
