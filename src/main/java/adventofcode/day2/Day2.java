package adventofcode.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Day2 {

    public Integer calculatePart1(String filename) {
        List<OuterValues> applicableNumbers = new ArrayList<>();
        List<List<Integer>> input = getInput(filename);
        input.stream().forEach(line -> applicableNumbers.add(OuterValues.from(line)));

        return applicableNumbers.stream().map(OuterValues::getDifference).reduce((int1, int2) -> int1 + int2).orElse(0);
    }

    public Integer calculatePart2(String filename) {
        List<List<Integer>> input = getInput(filename);
        return input.stream()
                .map(this::getDividableValues)
                .map(OuterValues::getDivision)
                .reduce((int1, int2) -> int1 + int2)
                .orElse(0);
    }

    private OuterValues getDividableValues(List<Integer> line) {
        final OuterValues[] result = new OuterValues[1];
        for (int i = 0; i < line.size(); i++) {
            List<Integer> compareTo = new ArrayList<>(line);
            compareTo.remove(i);
            int finalI = i;
            compareTo.forEach(value -> {
                if (line.get(finalI) % value == 0) {
                    result[0] = new OuterValues(value, line.get(finalI));
                }
            });

        }
        return result[0];
    }

    List<List<Integer>> getInput(String filename) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            URL resource = this.getClass().getClassLoader().getResource(filename);
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
            reader.lines()
                    .map(line -> Pattern.compile(";").splitAsStream(line).map(Integer::valueOf).collect(toList()))
                    .forEach(line -> result.add(line));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
