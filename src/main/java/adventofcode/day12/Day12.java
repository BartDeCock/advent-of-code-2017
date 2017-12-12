package adventofcode.day12;

import adventofcode.util.InputReader;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day12 {

    private Map<Integer, List<Integer>> input;
    private Multimap<Integer, Integer> groups = HashMultimap.create();

    int calculatePart1(String filename) {
        input = getInput(filename);
        input.get(0).forEach(pipe -> addPipe(0, pipe));
        return groups.get(0).size();
    }

    int calculatePart2(String filename) {
        input = getInput(filename);

        input.keySet().forEach(inputKey -> {
            if (!groups.containsValue(inputKey)) {
                input.get(inputKey).forEach(pipe -> addPipe(inputKey, pipe));
            }
        });
        return groups.keySet().size();
    }

    private void addPipe(Integer key, Integer pipe) {
        if (groups.put(key, pipe)) {
            input.get(pipe).forEach(p -> addPipe(key, p));
        }
    }

    private Map<Integer, List<Integer>> getInput(String filename) {
        List<String> lines = new InputReader().getLinesAsString(filename);
        Map<Integer, List<Integer>> input = new HashMap<>();

        lines.forEach(line -> {
            int index = line.indexOf('<');
            int key = Integer.valueOf(line.substring(0, index - 1));
            input.put(key, Arrays.asList(line.substring(index + 4).split(",")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList()));
        });
        return input;
    }

}
