package adventofcode.day17;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day17Test {

    @Test
    public void testPart1() {
        assertThat(new Day17().calculatePart1(3)).isEqualTo(638);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day17().calculatePart1(329)).isEqualTo(725);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day17().calculatePart2(329)).isEqualTo(27361412);
    }

}