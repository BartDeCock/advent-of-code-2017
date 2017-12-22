package adventofcode.day19;

import adventofcode.util.Direction;
import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.List;

import static adventofcode.util.Direction.*;

public class Day19 {
    private char[][] maze = new char[201][201];
    private List<Character> result = new ArrayList<>();
    private int steps = 0;

    String part1(String filename) {
        initMaze(filename);
        int start = 0;
        for (int i = 0; i < maze[0].length; i++) {
            if (maze[0][i] == '|') start = i;
        }

        walk(start, 0, DOWN);

        return result.stream().map(String::valueOf).reduce((s1, s2) -> s1+s2).get();
    }

    int part2(String filename) {
        initMaze(filename);
        int start = 0;
        for (int i = 0; i < maze[0].length; i++) {
            if (maze[0][i] == '|') start = i;
        }

        walk(start, 0, DOWN);

        return steps;
    }

    private boolean walk(int x, int y, Direction direction) {
        if (isOutOfBorder(x, y)) return false;
        if (isEmpty(x, y)) return false;

        steps++;
        if (isPlus(x, y)) {
            if (direction.equals(DOWN) || direction.equals(UP)) {
                return walk(x + 1, y, RIGHT) || walk(x - 1, y, LEFT);
            } else {
                return walk(x, y - 1, UP) || walk(x, y + 1, DOWN);
            }
        }
        if (isLetter(x, y)) {
            result.add(maze[y][x]);
        }
        if (direction.equals(DOWN)) walk(x, y + 1, DOWN);
        else if (direction.equals(UP)) walk(x, y - 1, UP);
        else if (direction.equals(LEFT)) walk(x - 1, y, LEFT);
        else if (direction.equals(RIGHT)) walk(x + 1, y, RIGHT);

        return true;
    }

    private boolean isPlus(int x, int y) {
        return maze[y][x] == '+';
    }

    private boolean isLetter(int x, int y) {
        return maze[y][x] >= 'A' && maze[y][x] <= 'Z';
    }

    private boolean isEmpty(int x, int y) {
        return maze[y][x] != '|' && maze[y][x] != '-' && maze[y][x] != '+' && !isLetter(x, y);
    }

    private boolean isOutOfBorder(int x, int y) {
        return x < 0 || y < 0 || x >= maze[y].length || y >= maze.length;
    }

    private void initMaze(String filename) {
        List<String> lines = new InputReader().getLinesAsString(filename);
        int y = 0;
        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (int x = 0; x < chars.length; x++) {
                maze[y][x] = chars[x];
            }
            y++;
        }
    }

}
