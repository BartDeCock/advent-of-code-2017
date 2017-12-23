package adventofcode.day23;

import adventofcode.util.InputReader;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day23 {

    private Map<String, Long>[] frequencies = new Map[]{new HashMap<String, Long>(), new HashMap<String, Long>()};
    private Boolean[] waits = new Boolean[]{false, false};
    private Integer[] programIndexes = new Integer[]{0, 0};
    private int countMul = 0;

    int part1(String filename) {
        List<String> instructions = new InputReader().getLinesAsString(filename);
        instructions.forEach(s -> {
            frequencies[0].put(s.substring(4, 5), 0L);
        });

        while (true) {
            try {
                executePart2(0, instructions.get(programIndexes[0]));

            } catch (Exception e) {
                break;
            }
        }
        return countMul;
    }

    int part2(String filename) {
        int b, c, d, f, g, h;
        h=0;
        b = 93 * 100 + 100000;
        c = b + 17000;
        do {
            f = 1;
            for (d = 2; d * d <= b; d++) {
                if ((b % d == 0)) { // check if b is a prime
                    f = 0;
                    break;
                }
            }
            if (f == 0) // not a prime
                h++;
            g = b - c;
            b += 17;
        } while (g != 0); //stop when b==c

        return h;
    }

    private void executePart2(int id, String instruction) {
        int other = id == 0 ? 1 : 0;
        waits[other] = false;
        String[] split = instruction.split(" ");
        if (split[0].equals("set")) {
            frequencies[id].put(split[1], getValue(id, split[2]));
            ++programIndexes[id];
        } else if (split[0].equals("sub")) {
            frequencies[id].put(split[1], frequencies[id].get(split[1]) - getValue(id, split[2]));
            ++programIndexes[id];
        } else if (split[0].equals("mul")) {
            frequencies[id].put(split[1], frequencies[id].get(split[1]) * getValue(id, split[2]));
            ++programIndexes[id];
            countMul++;
        } else if (split[0].equals("jnz")) {
            if (getValue(id, split[1]) != 0) {
                programIndexes[id] = programIndexes[id] + getValue(id, split[2]).intValue();
            } else {
                ++programIndexes[id];
            }
        } else {
            throw new RuntimeException("Unknown instruction: " + split[0]);
        }
    }

    private Long getValue(int id, String input) {
        return NumberUtils.isCreatable(input) ? Long.valueOf(input) : frequencies[id].get(input);
    }
}
