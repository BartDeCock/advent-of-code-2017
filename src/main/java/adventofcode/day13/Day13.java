package adventofcode.day13;

import adventofcode.util.InputReader;

import java.util.*;

import static java.lang.Integer.valueOf;

public class Day13 {
    private Map<Integer, Integer> input = new HashMap<>();
    private List<Integer> hits = new ArrayList<>();

    int calculatePart1(String filename) {
        getInput(filename);
        for (int i = 0; i <= input.keySet().stream().max(Integer::compareTo).get(); i++) {
            if (input.keySet().contains(i) && willBeHit(i, 0)) {
                hits.add(i);
            }
        }

        final int[] result = {0};
        hits.forEach(hit -> result[0] = result[0] + input.get(hit) * hit);
        return result[0];
    }

    int calculatePart2(String filename) {
        getInput(filename);
        boolean hit = true;
        int delay = 0;
        while (hit) {
            hit = false;
            for (int i = 0; i <= input.keySet().stream().max(Integer::compareTo).get(); i++) {
                if (input.keySet().contains(i) && willBeHit(i, delay)) {
                    hit = true;
                }
            }
            delay++;
        }
        return delay - 1;
    }

    private boolean willBeHit(int i, int delay) {
        return ((i + delay) % ((input.get(i) - 1) * 2)) == 0;
    }

    private void getInput(String filename) {
        new InputReader().getLinesAsString(filename).forEach(line -> {
            String[] split = line.split(": ");
            input.put(valueOf(split[0]), valueOf(split[1]));
        });
    }
}