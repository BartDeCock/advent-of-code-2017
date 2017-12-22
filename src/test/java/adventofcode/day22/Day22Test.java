package adventofcode.day22;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day22Test {

    @Test
    public void testPart1() {
        assertThat(new Day22().part1("day22-test.txt", 70)).isEqualTo(41);
        assertThat(new Day22().part1("day22-test.txt", 10_000)).isEqualTo(5587);
    }

    @Test
    public void part1() {
        assertThat(new Day22().part1("day22-input.txt", 10_000)).isEqualTo(5261);
    }

    @Test
    public void testPart2() {
        assertThat(new Day22().part2("day22-test.txt", 100)).isEqualTo(26);
        assertThat(new Day22().part2("day22-test.txt", 10_000_000)).isEqualTo(2511944);
    }

    @Test
    public void part2() {
        assertThat(new Day22().part2("day22-input.txt", 10_000_000)).isEqualTo(2511927);
    }
}