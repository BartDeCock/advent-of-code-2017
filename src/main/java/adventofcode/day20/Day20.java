package adventofcode.day20;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;
import static java.util.stream.Collectors.toList;

public class Day20 {
    private List<Particle> particles = new ArrayList<>();

    int part1(String filename) {
        int id = 0;
        for (String line : new InputReader().getLinesAsString(filename)) {
            particles.add(createParticle(id, line));
            id++;
        }
        for (int i = 0; i < 1000; i++) {
            particles.forEach(Particle::tick);
        }
        return particles.stream().reduce((p1, p2) -> p1.distance() < p2.distance() ? p1 : p2).get().getId();
    }

    private Particle createParticle(int id, String s) {
        String[] split = s.split(", ");
        return new Particle(id,
                new Position(getCoordinates(split[0]).x, getCoordinates(split[0]).y, getCoordinates(split[0]).z),
                new Velocity(getCoordinates(split[1]).x, getCoordinates(split[1]).y, getCoordinates(split[1]).z),
                new Acceleration(getCoordinates(split[2]).x, getCoordinates(split[2]).y, getCoordinates(split[2]).z));
    }

    private Coordinate getCoordinates(String input) {
        Pattern p = Pattern.compile("<(-?\\d*),(-?\\d*),(-?\\d*)>");
        Matcher m = p.matcher(input);
        Coordinate c = null;
        while (m.find()) {
            c = new Coordinate(valueOf(m.group(1)), valueOf(m.group(2)), valueOf(m.group(3)));
        }
        return c;
    }

    int part2(String filename) {
        int id = 0;
        List<String> lines = new InputReader().getLinesAsString(filename);
        for (String line : lines) {
            Particle particle = createParticle(id, line);
            particles.add(particle);
            id++;
        }
        filterCollisions();
        for (int i = 0; i < 1000; i++) {
            particles.stream().map(Particle::tick).collect(toList());
            filterCollisions();
        }
        return particles.size();
    }

    private void filterCollisions() {
        Set<Position> positions = new HashSet<>();
        List<Position> positionsToRemove = new ArrayList<>();
        particles.forEach(particle -> {
            if (!positions.add(particle.getPosition())) positionsToRemove.add(particle.getPosition());
        });
        particles = particles.stream().filter(particle -> !positionsToRemove.contains(particle.getPosition())).collect(Collectors.toList());
    }

    class Coordinate {
        int x, y, z;

        Coordinate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
