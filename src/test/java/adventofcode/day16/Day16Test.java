package adventofcode.day16;

import adventofcode.day15.Day15;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day16Test {

    @Test
    public void testPart1() {
        assertThat(new Day16().calculatePart1("day16-test.txt", "abcde")).isEqualTo("baedc");
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day16().calculatePart1("day16-input.txt", "abcdefghijklmnop")).isEqualTo("ehdpincaogkblmfj");
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day16().calculatePart2("day16-input.txt", "abcdefghijklmnop")).isEqualTo("bpcekomfgjdlinha");
    }

}