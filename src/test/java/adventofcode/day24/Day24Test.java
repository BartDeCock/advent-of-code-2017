package adventofcode.day24;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Day24Test {

    @Test
    public void testPart1() {
        assertThat(new Day24().part1("day24-test.txt")).isEqualTo(31);
    }

    @Test
    public void part1() {
        assertThat(new Day24().part1("day24-input.txt")).isEqualTo(1906);
    }

    @Test
    public void testPart2() {
        assertThat(new Day24().part2("day24-test.txt")).isEqualTo(19);
    }

    @Test
    public void part2() {
        assertThat(new Day24().part2("day24-input.txt")).isEqualTo(1824);
    }
}