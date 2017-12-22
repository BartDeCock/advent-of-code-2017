package adventofcode.day22;

import adventofcode.util.InputReader;
import adventofcode.util.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static adventofcode.util.Direction.*;

public class Day22 {
    private static final int CENTER_X = 4444;
    private static final int CENTER_Y = 4444;

    private Virus virus = new Virus();
    private Map<Point, Node> nodes = new HashMap<>();

    int part1(String filename, int moves) {
        int infections =0;
        init(filename);
        virus.setCurrentNode(nodes.get(new Point(CENTER_X, CENTER_Y)));
        virus.setCurrentDirection(UP);
        for (int i = 0; i < moves; i++) {
            virus.switchDirection();
            if (virus.execute()) infections++;
            move();
        }
        return infections;
    }

    int part2(String filename, int moves) {
        int infections =0;
        init(filename);
        virus.setCurrentNode(nodes.get(new Point(CENTER_X, CENTER_Y)));
        virus.setCurrentDirection(UP);
        for (int i = 0; i < moves; i++) {
            virus.switchDirection();
            if (virus.executePart2()) infections++;
            move();
        }
        return infections;
    }

    private void move() {
        Point next = virus.move();
        Node nextNode = nodes.computeIfAbsent(next, point -> new Node(point.getX(), point.getY(), '.'));
        virus.setCurrentNode(nextNode);
    }

    private void init(String filename) {
        List<String> lines = new InputReader().getLinesAsString(filename);
        int diff = (lines.size() - 1) / 2;
        int y = CENTER_Y - diff;
        for (String line : lines) {
            int x = CENTER_X - diff;
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                nodes.put(new Point(x, y), new Node(x, y, chars[i]));
                x++;
            }
            y++;
        }
    }
}
