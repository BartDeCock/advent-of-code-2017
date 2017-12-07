package adventofcode.day6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class Day6Test {

    @Test
    public void testDataPart1() {
        assertThat(new Day6().calculatePart1("day6-test.txt")).isEqualTo(5);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day6().calculatePart1("day6-input.txt")).isEqualTo(14029);
    }

    @Test
    public void testDataPart2() {
        assertThat(new Day6().calculatePart2("day6-test.txt")).isEqualTo(4);

    }

    @Test
    public void calculatePart2() {
        assertThat(new Day6().calculatePart2("day6-input.txt")).isEqualTo(2765);
    }
}