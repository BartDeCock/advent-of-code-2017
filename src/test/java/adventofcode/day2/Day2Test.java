package adventofcode.day2;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    private Day2 calculator = new Day2();

    @Test
    public void testDataPart1() throws IOException {
        Integer actual = calculator.calculatePart1("example.csv");
        assertThat(actual).isEqualTo(18);
    }

    @Test
    public void calculatePart1() throws IOException {
        Integer actual = calculator.calculatePart1("day2-input.csv");
        assertThat(actual).isEqualTo(44887);
    }

    @Test
    public void testDataPart2() throws IOException {
        Integer actual = calculator.calculatePart2("part2.csv");
        assertThat(actual).isEqualTo(9);
    }

    @Test
    public void calculatePart2() throws IOException {
        Integer actual = calculator.calculatePart2("day2-input.csv");
        assertThat(actual).isEqualTo(242);
    }

}