package adventofcode.day18;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class Day18Test {
    @Test
    public void testPart1() throws Exception {
        assertThat(new Day18().calculatePart1("day18-test.txt")).isEqualTo(0);
    }

    @Test
    public void calculatePart1() throws Exception {
        assertThat(new Day18().calculatePart1("day18-input.txt")).isEqualTo(0);
    }

    @Test
    public void testPart2() throws Exception {
        assertThat(new Day18().calculatePart2("day18-test.txt")).isEqualTo(0);
    }

    @Test
    public void calculatePart2() throws Exception {
        assertThat(new Day18().calculatePart2("day18-input.txt")).isEqualTo(0);
    }

}