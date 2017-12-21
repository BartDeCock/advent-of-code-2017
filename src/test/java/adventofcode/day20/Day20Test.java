package adventofcode.day20;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day20Test {
    @Test
    public void testPart1() throws Exception {
        assertThat(new Day20().part1("day20-test.txt")).isEqualTo(0);
    }

    @Test
    public void part1() throws Exception {
        assertThat(new Day20().part1("day20-input.txt")).isEqualTo(157);
    }

    @Test
    public void testPart2() throws Exception {
        assertThat(new Day20().part2("day20-test2.txt")).isEqualTo(1);
    }

    @Test
    public void part2() throws Exception {
        // 990 too high
        assertThat(new Day20().part2("day20-input.txt")).isEqualTo(499);
    }


}