package adventofcode.day10;

import io.reactivex.Observable;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10Test {

    @Test
    public void testPart1() {
        assertThat(new Day10().calculatePart1(
                "day10/day10-test.txt",
                Observable.range(0, 5).toList().blockingGet()))
                .isEqualTo(12);
    }

    @Test
    public void calculatePart1() {
        assertThat(new Day10().calculatePart1(
                "day10-input.txt",
                Observable.range(0, 256).toList().blockingGet()))
                .isEqualTo(826);
    }

    @Test
    public void testPart2() {
        assertThat(new Day10().calculatePart2(
                "day10/day10-test2.txt",
                Observable.range(0, 256).toList().blockingGet()))
                .isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
    }

    @Test
    public void calculatePart2() {
        assertThat(new Day10().calculatePart2(
                "day10-input.txt",
                Observable.range(0, 256).toList().blockingGet()))
                .isEqualTo("d067d3f14d07e09c2e7308c3926605c4");
    }
}