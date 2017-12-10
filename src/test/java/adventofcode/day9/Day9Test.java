package adventofcode.day9;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class Day9Test {

    @Test
    public void testPart1() {
        assertThat(new Day9().calculatePart1("day9/day9-test1.txt").getScore()).isEqualTo(1);
        assertThat(new Day9().calculatePart1("day9/day9-test2.txt").getScore()).isEqualTo(6);
        assertThat(new Day9().calculatePart1("day9/day9-test3.txt").getScore()).isEqualTo(5);
        assertThat(new Day9().calculatePart1("day9/day9-test4.txt").getScore()).isEqualTo(16);
        assertThat(new Day9().calculatePart1("day9/day9-test5.txt").getScore()).isEqualTo(1);
        assertThat(new Day9().calculatePart1("day9/day9-test6.txt").getScore()).isEqualTo(9);
        assertThat(new Day9().calculatePart1("day9/day9-test7.txt").getScore()).isEqualTo(9);
        assertThat(new Day9().calculatePart1("day9/day9-test8.txt").getScore()).isEqualTo(3);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day9().calculatePart1("day9-input.txt").getScore()).isEqualTo(11089);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day9().calculatePart2("day9-input.txt").getGarbageCount()).isEqualTo(5288);

    }

}