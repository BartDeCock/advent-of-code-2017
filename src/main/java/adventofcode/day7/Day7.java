package adventofcode.day7;

import adventofcode.util.InputReader;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 {
    private Map<String, Integer> discs = new HashMap<>();
    private ListMultimap<String, String> children = ArrayListMultimap.create();

    String calculatePart1(String filename) {
        List<String> allNames = new ArrayList<>();
        List<String> allPrograms = new ArrayList<>();
        new InputReader().getLinesAsString(filename).forEach(line -> {
            String[] words = line.split(";");
            if (words.length > 2) {
                allNames.add(words[0]);
                for (int i = 2; i < words.length; i++) {
                    allPrograms.add(words[i]);
                }
            }
        });
        allNames.removeAll(allPrograms);
        System.out.println("Size should be one:" + allNames.size());
        return allNames.get(0);
    }

    Integer calculatePart2(String filename) {
        new InputReader().getLinesAsString(filename).forEach(line -> {
            String[] words = line.split(";");
            discs.put(words[0], Integer.valueOf(words[1]));
            for (int i = 2; i < words.length; i++) {
                children.put(words[0], words[i]);
            }
        });

        return checkBalance(calculatePart1(filename));

    }

    private int checkBalance(String disc) {
        Map<String, Integer> values = new HashMap<>();
        for (String sub: children.get(disc)) {
            if (children.containsKey(sub)) {
                values.put(sub, checkBalance(sub));
            } else {
                values.put(sub, discs.get(sub));
            }
        }
        if (values.values().stream().distinct().count() > 1) {
            System.out.println("BROKEN for " + disc + " with values " + values);
            System.exit(0);
        }
        return values.values().stream().reduce((i1, i2) -> i1+i2).get() + discs.get(disc);

    }

}
