package adventofcode.day11;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11Test {

    @Test
    public void testPart1() {
        new Day11().calculatePart1("day11-test.txt");
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day11().calculatePart1("day11-input.txt").getTotalSteps()).isEqualTo(650);

    }

    @Test
    public void calculatePart2() {
        assertThat(new Day11().calculatePart2("day11-input.txt")).isEqualTo(1465);
    }

}