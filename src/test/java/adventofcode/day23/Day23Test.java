package adventofcode.day23;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day23Test {

    @Test
    public void part1() {
        assertThat(new Day23().part1("day23-input.txt")).isEqualTo(8281);
    }

    @Test
    public void part2() {
        assertThat(new Day23().part2("day23-input.txt")).isEqualTo(911);
//        assertThat(new Day23().main()).isEqualTo(911);
    }
}