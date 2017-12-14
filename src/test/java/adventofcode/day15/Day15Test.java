package adventofcode.day15;

import adventofcode.day14.Day14;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day15Test {
    @Test
    public void testPart1() {
        assertThat(new Day15().calculatePart1("day15-test.txt")).isEqualTo(0);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day15().calculatePart1("day15-input.txt")).isEqualTo(0);
    }

    @Test
    public void testPart2() {
        assertThat(new Day15().calculatePart2("day15-test.txt")).isEqualTo(0);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day15().calculatePart2("day15-input.txt")).isEqualTo(0);
    }
}