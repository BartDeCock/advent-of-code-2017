package adventofcode.day7;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class Day7Test {

    @Test
    public void testDataPart1() {
        assertThat(new Day7().calculatePart1("day7-test.txt")).isEqualTo("tknk");
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day7().calculatePart1("day7-input.txt")).isEqualTo("rqwgj");
    }

    @Test
    public void testDataPart2() {
        new Day7().calculatePart2("day7-test.txt");
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day7().calculatePart2("day7-input.txt")).isEqualTo("rqwgj");
    }
}