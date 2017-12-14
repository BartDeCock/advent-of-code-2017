package adventofcode.day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day14Test {

    @Test
    public void testPart1() {
        assertThat(new Day14().calculatePart1("flqrgnkx")).isEqualTo(8108L);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day14().calculatePart1("stpzcrnm")).isEqualTo(8250);
    }

    @Test
    public void testPart2() {
        assertThat(new Day14().calculatePart2("flqrgnkx")).isEqualTo(1242);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day14().calculatePart2("stpzcrnm")).isEqualTo(1113);
    }

}