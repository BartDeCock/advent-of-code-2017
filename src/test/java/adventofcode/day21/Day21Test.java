package adventofcode.day21;

import adventofcode.day20.Day20;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day21Test {
    @Test
    public void testPart1() throws Exception {
        assertThat(new Day21().part1("day21-test.txt",2)).isEqualTo(12);
    }

    @Test
    public void part1() throws Exception {
        assertThat(new Day21().part1("day21-input.txt",5)).isEqualTo(158);
    }

    @Test
    public void part2() throws Exception {
        assertThat(new Day21().part2("day21-input.txt", 18)).isEqualTo(2301762);
    }
}