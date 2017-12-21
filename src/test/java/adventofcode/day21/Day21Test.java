package adventofcode.day21;

import adventofcode.day20.Day20;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day21Test {
    @Test
    public void testPart1() throws Exception {
        assertThat(new Day21().part1("day21-test.txt")).isEqualTo(0);
    }

    @Test
    public void part1() throws Exception {
        assertThat(new Day21().part1("day21-input.txt")).isEqualTo(0);
    }

    @Test
    public void testPart2() throws Exception {
        assertThat(new Day21().part2("day21-test2.txt")).isEqualTo(0);
    }

    @Test
    public void part2() throws Exception {
        // 990 too high
        assertThat(new Day21().part2("day21-input.txt")).isEqualTo(0);
    }
}