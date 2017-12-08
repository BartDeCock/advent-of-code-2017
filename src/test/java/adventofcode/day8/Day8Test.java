package adventofcode.day8;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Day8Test {

    @Test
    public void testPart1() throws Exception {
        assertThat(new Day8().calculatePart1("day8-test.txt")).isEqualTo(1);

    }

    @Test
    public void calculatePart1() throws Exception {
        assertThat(new Day8().calculatePart1("day8-input.txt")).isEqualTo(4902);
    }

    @Test
    public void testPart2() throws Exception {
        assertThat(new Day8().calculatePart2("day8-test.txt")).isEqualTo(10);
    }

    @Test
    public void calculatePart2() throws Exception {
        assertThat(new Day8().calculatePart2("day8-input.txt")).isEqualTo(7037);
    }

}