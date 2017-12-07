package adventofcode.day6;

import adventofcode.util.InputReader;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Day6 {

    private List<Integer> compareTo;

    Integer calculatePart1(String filename) {
        Set<Integer[]> result = new HashSet<>();
        Set<List<Integer>> r2 = new HashSet<>();
        String[] split = new InputReader().getLinesAsString(filename).get(0).split(";");
        Integer[] numbers = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.valueOf(split[i]);
        }
        add(r2, numbers);
        boolean infinite = false;

        do {
            int index = indexOfMaxValue(numbers);
            int val = numbers[index];
//            System.out.println("Max=" + val + " on index=" + index);
            numbers[index] = 0;
            for (int m = val; m > 0; m--) {
//                System.out.println("iterations left:" + m);
                if (index == (numbers.length - 1)) {
//                    System.out.println("end reached at index=" + index);
                    index = -1;
                }
                index++;
                numbers[index]++;

//                print(numbers);
            }
            if (!add(r2, numbers)) infinite = true;
//            System.out.println(r2);
        } while (!infinite);


        return r2.size();
    }

    Integer calculatePart2(String filename) {
        Set<Integer[]> result = new HashSet<>();
        Set<List<Integer>> r2 = new HashSet<>();
        String[] split = new InputReader().getLinesAsString(filename).get(0).split(";");
        Integer[] numbers = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.valueOf(split[i]);
        }
        add(r2, numbers);
        boolean infinite = false;
        int infiniteCount = 0;

        do {
            int index = indexOfMaxValue(numbers);
            int val = numbers[index];
//            System.out.println("Max=" + val + " on index=" + index);
            numbers[index] = 0;
            for (int m = val; m > 0; m--) {
//                System.out.println("iterations left:" + m);
                if (index == (numbers.length - 1)) {
//                    System.out.println("end reached at index=" + index);
                    index = -1;
                }
                index++;
                numbers[index]++;

//                print(numbers);
            }
            if (!add(r2, numbers)) {
                infinite = true;
//                System.out.print("First loop ended with dubplicate array: ");
//                print(numbers);
            }
//            System.out.println(r2);
        } while (!infinite);

        int steps = 0;
//        System.out.println("Compare with: " + compareTo);
//        print(numbers);
        do {
            steps++;
//            System.out.println("Taking step " + steps);
            int index = indexOfMaxValue(numbers);
            int val = numbers[index];
//            System.out.println("Max=" + val + " on index=" + index);
            numbers[index] = 0;
            for (int m = val; m > 0; m--) {
//                System.out.println("iterations left:" + m);
                if (index == (numbers.length - 1)) {
//                    System.out.println("end reached at index=" + index);
                    index = -1;
                }
                index++;
                numbers[index]++;

                print(numbers);
            }
//            System.out.println("End step " + steps);
//            System.out.println(r2);
        } while (!compareTo.equals(stream(numbers).collect(toList())));



        //

        return steps;
    }


    private boolean add(Set<List<Integer>> r2, Integer[] numbers) {
        List<Integer> integers = stream(numbers).collect(toList());
        boolean isNew = r2.add(integers);
        if (!isNew) {
//            System.out.println(integers + " already exists in Set");
            compareTo = integers;
        }
        return isNew;
    }

    private int indexOfMaxValue(Integer[] numbers) {
        int max = MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                idx = i;
            }
        }
        return idx;
    }

    private void print(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ";");
        }
        System.out.print("\n");
    }
}
