package adventofcode.day12;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12Test {

    @Test
    public void testPart1() {
        assertThat(new Day12().calculatePart1("day12-test.txt")).isEqualTo(6);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day12().calculatePart1("day12-input.txt")).isEqualTo(145);

    }

    @Test
    public void testPart2() {
        assertThat(new Day12().calculatePart2("day12-test.txt")).isEqualTo(2);
    }


    @Test
    public void calculatePart2() {
        assertThat(new Day12().calculatePart2("day12-input.txt")).isEqualTo(207);
    }

}