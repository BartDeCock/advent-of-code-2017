package adventofcode.day8;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {
    private List<Instruction> instructions = new ArrayList<>();
    private Map<String, Integer> values = new HashMap<>();

    int calculatePart1(String filename) {
        new InputReader().getLinesAsString(filename)
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    instructions.add(new Instruction(parts[0], parts[1], parts[2], parts[4], parts[5], parts[6]));
                    values.put(parts[0], 0);
                });

        System.out.println(values);

        instructions.forEach(instruction -> {
            values.put(instruction.getId(), instruction.execute(values.get(instruction.getId()), values.get(instruction.getCondition().getRegisterId())));
            System.out.println(values);
        });

        return values.values().stream().max(Integer::compareTo).get();
    }

    int calculatePart2(String filename) {
        final Integer[] max = {Integer.MIN_VALUE};
        new InputReader().getLinesAsString(filename)
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    instructions.add(new Instruction(parts[0], parts[1], parts[2], parts[4], parts[5], parts[6]));
                    values.put(parts[0], 0);
                });

        System.out.println(values);

        instructions.forEach(instruction -> {
            int newValue = instruction.execute(values.get(instruction.getId()), values.get(instruction.getCondition().getRegisterId()));
            values.put(instruction.getId(), newValue);
            if (newValue > max[0]) max[0] = newValue;
            System.out.println(values);
            System.out.println("Current max: " + max[0]);
        });

        return max[0];
    }
}
