package adventofcode.day16;

import adventofcode.util.InputReader;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Day16 {

    private char[] programs;

    String calculatePart1(String filename, String given) {
        List<String> moves = Arrays.asList(new InputReader().getLinesAsString(filename).get(0).split(","));
        this.programs = given.toCharArray();
        return calculate1Loop(moves);
    }

    String calculatePart2(String filename, String given) {
        this.programs = given.toCharArray();
        List<String> moves = Arrays.asList(new InputReader().getLinesAsString(filename).get(0).split(","));
        calculate1Loop(moves);
        int loop = 1;
        while (!valueOf(programs).equals(given)) {
            calculate1Loop(moves);
            loop++;
        }
        int mod = 1_000_000_000 % loop;
        for (int i = 0; i < mod; i++) {
            calculate1Loop(moves);
        }
        return valueOf(programs);
    }

    private String calculate1Loop(List<String> moves) {
        moves.forEach(move -> {
            if (move.startsWith("s")) spin(parseInt(move.substring(1)));
            if (move.startsWith("x")) {
                String[] split = move.substring(1).split("/");
                swap(Integer.valueOf(valueOf(split[0])), Integer.valueOf(valueOf(split[1])));
            }
            if (move.startsWith("p")) swap(getIndex(move.charAt(1)), getIndex(move.charAt(3)));
        });
        return valueOf(programs);
    }
    private int getIndex(char c) {
        for (int i = 0; i < programs.length; i++) {
            if (programs[i] == c) return i;
        }
        throw new RuntimeException();
    }

    private void swap(int i1, int i2) {
        char x = programs[i1];
        programs[i1] = programs[i2];
        programs[i2] = x;
    }

    private void spin(int places) {
        char[] temp = new char[programs.length];
        System.arraycopy(programs, programs.length - places, temp, 0, places);
        System.arraycopy(programs, 0, temp, places, programs.length - places);
        programs = temp;
    }

}
