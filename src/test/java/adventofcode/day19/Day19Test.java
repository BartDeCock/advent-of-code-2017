package adventofcode.day19;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day19Test {

    @Test
    public void testPart1() {
        assertThat(new Day19().part1("day19-test.txt")).isEqualTo("ABCDEF");
    }

    @Test
    public void part1() {
        assertThat(new Day19().part1("day19-input.txt")).isEqualTo("ABCDEF");
    }

    @Test
    public void testPart2() {
        assertThat(new Day19().part2("day19-test.txt")).isEqualTo(38);
    }

    @Test
    public void part2() {
        assertThat(new Day19().part2("day19-input.txt")).isEqualTo(16328);
    }

}