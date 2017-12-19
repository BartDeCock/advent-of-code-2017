package adventofcode.day18;

import adventofcode.util.InputReader;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class Day18 {

    private Map<String, Long>[] frequencies = new Map[]{new HashMap<String, Long>(), new HashMap<String, Long>()};
    private Boolean[] waits = new Boolean[]{false, false};
    private Integer[] programIndexes = new Integer[]{0, 0};
    private Queue<Long>[] queues = new Queue[]{new LinkedList<Long>(), new LinkedList<Long>()};
    private Integer[] sent = new Integer[]{0, 0};

    Long calculatePart1(String filename) {
        List<String> instructions = new InputReader().getLinesAsString(filename);
        instructions.forEach(s -> {
            frequencies[0].put(s.substring(4, 5), 0L);
        });

        while (!waits[0]) {
            executePart2(0, instructions.get(programIndexes[0]));
        }
        return ((LinkedList<Long>) queues[1]).getLast();
    }

    int calculatePart2(String filename) {
        List<String> instructions = new InputReader().getLinesAsString(filename);
        instructions.forEach(s -> {
            frequencies[0].put(s.substring(4, 5), 0L);
            frequencies[1].put(s.substring(4, 5), 0L);
        });
        frequencies[1].put("p", 1L);

        do {
            while (!waits[0]) {
                executePart2(0, instructions.get(programIndexes[0]));
            }
            while (!waits[1]) {
                executePart2(1, instructions.get(programIndexes[1]));
            }
        } while (!bothQueuesAreEmpty());

        return sent[1];
    }

    private boolean bothQueuesAreEmpty() {
        return queues[0].isEmpty() && queues[1].isEmpty();
    }

    private void executePart2(int id, String instruction) {
        int other = id == 0 ? 1 : 0;
        waits[other] = false;
        String[] split = instruction.split(" ");
        if (split[0].equals("set")) {
            frequencies[id].put(split[1], getValue(id, split[2]));
            ++programIndexes[id];
        } else if (split[0].equals("add")) {
            frequencies[id].put(split[1], frequencies[id].get(split[1]) + getValue(id, split[2]));
            ++programIndexes[id];
        } else if (split[0].equals("mul")) {
            frequencies[id].put(split[1], frequencies[id].get(split[1]) * getValue(id, split[2]));
            ++programIndexes[id];
        } else if (split[0].equals("mod")) {
            frequencies[id].put(split[1], frequencies[id].get(split[1]) % getValue(id, split[2]));
            ++programIndexes[id];
        } else if (split[0].equals("jgz")) {
            if (getValue(id, split[1]) > 0) {
                programIndexes[id] = programIndexes[id] + getValue(id, split[2]).intValue();
            } else {
                ++programIndexes[id];
            }
        } else if (split[0].equals("rcv")) {
            Long poll = queues[id].poll();
            if (poll == null) {
                waits[id] = true;
            } else {
                frequencies[id].put(split[1], poll);
                ++programIndexes[id];
            }
        } else if (split[0].equals("snd")) {
            queues[other].add(frequencies[id].get(split[1]));
            sent[id]++;
            ++programIndexes[id];
        } else {
            throw new RuntimeException("Unknown instruction: " + split[0]);
        }
    }

    private Long getValue(int id, String input) {
        return NumberUtils.isCreatable(input) ? Long.valueOf(input) : frequencies[id].get(input);
    }

}
