package adventofcode.day15;

import adventofcode.day14.Day14;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day15Test {
    static final int startA=618;
    static final int testA=65;
    static final int startB=814;
    static final int testB=8921;
    @Test
    public void testPart1() {
        assertThat(new Day15().calculatePart1(testA, testB)).isEqualTo(588);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day15().calculatePart1(startA, startB)).isEqualTo(577);
    }

    @Test
    public void testPart2() {
        assertThat(new Day15().calculatePart2(testA, testB)).isEqualTo(309);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day15().calculatePart2(startA, startB)).isEqualTo(316);
    }
}