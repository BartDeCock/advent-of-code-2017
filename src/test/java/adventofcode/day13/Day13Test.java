package adventofcode.day13;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day13Test {

    @Test
    public void testPart1() {
        assertThat(new Day13().calculatePart1("day13-test.txt")).isEqualTo(24);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day13().calculatePart1("day13-input.txt")).isEqualTo(2384);
    }

    @Test
    public void testPart2() {
        assertThat(new Day13().calculatePart2("day13-test.txt")).isEqualTo(10);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day13().calculatePart2("day13-input.txt")).isEqualTo(3921270);
    }

}