package adventofcode.day5;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5Test {

    @Test
    public void testPart1() {
        assertThat(new Day5().calculatePart1("day5-test.txt")).isEqualTo(5);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day5().calculatePart1("day5-input.txt")).isEqualTo(326618);
    }

    @Test
    public void testPart2() {
        assertThat(new Day5().calculatePart2("day5-test.txt")).isEqualTo(10);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day5().calculatePart2("day5-input.txt")).isEqualTo(21841249);
    }

}