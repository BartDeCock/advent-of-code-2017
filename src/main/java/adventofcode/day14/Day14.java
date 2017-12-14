package adventofcode.day14;

import adventofcode.day10.Day10;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day14 {

    private Integer[][] bits = new Integer[128][128];

    Long calculatePart1(String input) {
        return hashes(input).stream().flatMap(Collection::stream).filter(bit -> bit == 1).count();
    }

    List<List<Integer>> hashes(String input) {
        List<List<Integer>> hashes = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            String knotHash = new Day10().knotHash(input + "-" + i);
            List<Integer> bits = new ArrayList<>();
            for (char c : knotHash.toCharArray()) {
                bits.addAll(hexToBin(c));
            }
            hashes.add(bits);
        }
        return hashes;
    }

    int calculatePart2(String input) {
        toArray(input);
        return calculateRegions();
    }

    private void toArray(String input) {
        List<List<Integer>> hashes = hashes(input);
        for (int i = 0; i < hashes.size(); i++) {
            for (int j = 0; j < hashes.get(i).size(); j++) {
                bits[i][j] = hashes.get(i).get(j);
            }
        }
    }

    private int calculateRegions() {
        int last = 10;
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < bits[i].length; j++) {
                if (bits[i][j] == 1) {
                    bits[i][j] = last;
                    updateNeighbors(i, j, last);
                    last++;
                }
            }
        }
//        print();
        return last - 10;
    }

    private void updateNeighbors(int i, int j, int last) {
        checkLeft(i, j, last);
        checkUp(i, j, last);
        checkRight(i, j, last);
        checkDown(i, j, last);
    }

    private void checkRight(int i, int j, int last) {
        if (j + 1 < bits[i].length && bits[i][j + 1] == 1) {
            bits[i][j + 1] = last;
            updateNeighbors(i, j + 1, last);
        }
    }

    private void checkLeft(int i, int j, int last) {
        if (j - 1 >= 0 && bits[i][j - 1] == 1) {
            bits[i][j - 1] = last;
            updateNeighbors(i, j - 1, last);
        }
    }

    private void checkUp(int i, int j, int last) {
        if (i - 1 >= 0 && bits[i - 1][j] == 1) {
            bits[i - 1][j] = last;
            updateNeighbors(i - 1, j, last);
        }
    }

    private void checkDown(int i, int j, int last) {
        if (i + 1 < bits.length && bits[i + 1][j] == 1) {
            bits[i + 1][j] = last;
            updateNeighbors(i + 1, j, last);
        }
    }

    private List<Integer> hexToBin(char c) {
        String s = new BigInteger(String.valueOf(c), 16).toString(2);
        while (s.length() < 4) {
            s = "0" + s;
        }
        return Arrays.stream(s.split("\\B"))
                .map(Integer::valueOf)
                .collect(toList());
    }

    private void print() {
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < bits[i].length; j++) {
                System.out.print(printRegion(i, j));
                System.out.print("-");
            }
            System.out.print("\n");

        }
    }

    private String printRegion(int i, int j) {
        String s = String.valueOf(bits[i][j]);
        while (s.length() < 4) {
            s = "0" + s;
        }
        return s;
    }
}
