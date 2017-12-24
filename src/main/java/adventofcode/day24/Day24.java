package adventofcode.day24;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.valueOf;
import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

public class Day24 {
    private List<Bridge> result = new ArrayList<Bridge>();
    private List<Component> input;
    private List<Component> components;

    int part1(String filename) {
        createBridges(filename);

//        System.out.println(result);
        return result.stream()
                .map(Bridge::getStrength)
                .max(Integer::compareTo)
                .get();
    }

    private void createBridges(String filename) {
        final int[] id = {0};
        input = new InputReader().getLinesAsString(filename)
                .stream()
                .map(line -> {
                    String[] split = line.split("/");
                    return new Component(id[0]++, valueOf(split[0]), valueOf(split[1]));
                })
                .collect(Collectors.toList());

        for (int i = 0; i < input.size(); i++) {
            Component current = input.get(i);
            if (current.hasZero()) {
                Component copy = current.copy();
                copy.setUsed(0);
                result.add(new Bridge(copy));
            }
        }

//        System.out.println(result);

        List<Bridge> currentList = new ArrayList<>(result);
        List<Bridge> nextBridges;
        do {
//            System.out.println("CurrentList at start: "+ currentList);
            nextBridges = new ArrayList<>();
            for (Bridge bridge : currentList) {
                List<Component> next = bridge.findNext(input);
                for (Component component : next) {
                    Bridge newBridge = new Bridge(bridge).add(component);
                    nextBridges.add(newBridge);
                    result.add(newBridge);
                }
            }
            currentList = new ArrayList<>(nextBridges);
        } while (!nextBridges.isEmpty());
    }

    int part2(String filename) {
        createBridges(filename);
        Bridge biggest = result.stream()
                .sorted(comparing(Bridge::getLength).thenComparing(Bridge::getStrength).reversed())
                .findFirst()
                .get();
        System.out.println(biggest);
        return biggest.getStrength();

    }

    private void findNext(Component component) {


    }
}
