package adventofcode.day4;

import io.reactivex.subscribers.TestSubscriber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4Test {

    @Test
    public void testPart1() {
        assertThat(new Day4().calculatePart1("day4-test.txt")).isEqualTo(2);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day4().calculatePart1("day4-input.txt")).isEqualTo(477);
    }

    @Test
    public void testPart2() {
        assertThat(new Day4().calculatePart2("day4-part2-test.txt")).isEqualTo(3);
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day4().calculatePart2("day4-input.txt")).isEqualTo(167);
    }
}