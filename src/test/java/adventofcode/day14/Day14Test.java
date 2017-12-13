package adventofcode.day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day14Test {

    @Test
    public void testPart1() {
        assertThat(new Day14().calculatePart1("day14-test.txt")).isEqualTo(0);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day14().calculatePart1("day14-input.txt")).isEqualTo(0);
    }

    @Test
    public void testPart2() {
        assertThat(new Day14().calculatePart2("day14-test.txt")).isEqualTo(0);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day14().calculatePart2("day14-input.txt")).isEqualTo(0);
    }

}