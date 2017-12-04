package adventofcode.day3;

import org.junit.Test;

import java.util.Map;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    @Test
    public void testDataPart1() {
        Day3 day3 = new Day3();
        Matrix matrix = day3.calculatePart1(23);

        assertThat(matrix.getCell(1)).isEqualToComparingFieldByField(new Cell(3,3, 1));
        assertThat(matrix.getCell(2)).isEqualToComparingFieldByField(new Cell(3,4, 2));
        assertThat(matrix.getCell(3)).isEqualToComparingFieldByField(new Cell(2,4, 3));
        assertThat(matrix.getCell(4)).isEqualToComparingFieldByField(new Cell(2,3, 4));
        assertThat(matrix.getCell(5)).isEqualToComparingFieldByField(new Cell(2,2, 5));
        assertThat(matrix.getCell(6)).isEqualToComparingFieldByField(new Cell(3,2, 6));
        assertThat(matrix.getCell(7)).isEqualToComparingFieldByField(new Cell(4,2, 7));
        assertThat(matrix.getCell(8)).isEqualToComparingFieldByField(new Cell(4,3, 8));
        assertThat(matrix.getCell(9)).isEqualToComparingFieldByField(new Cell(4,4, 9));
        assertThat(matrix.getCell(10)).isEqualToComparingFieldByField(new Cell(4,5, 10));
        assertThat(matrix.getCell(11)).isEqualToComparingFieldByField(new Cell(3,5, 11));
        assertThat(matrix.getCell(12)).isEqualToComparingFieldByField(new Cell(2,5, 12));
        assertThat(matrix.getCell(13)).isEqualToComparingFieldByField(new Cell(1,5, 13));
        assertThat(matrix.getCell(14)).isEqualToComparingFieldByField(new Cell(1,4, 14));
        assertThat(matrix.getCell(15)).isEqualToComparingFieldByField(new Cell(1,3, 15));
        assertThat(matrix.getCell(16)).isEqualToComparingFieldByField(new Cell(1,2, 16));
        assertThat(matrix.getCell(17)).isEqualToComparingFieldByField(new Cell(1,1, 17));
        assertThat(matrix.getCell(18)).isEqualToComparingFieldByField(new Cell(2,1, 18));
        assertThat(matrix.getCell(19)).isEqualToComparingFieldByField(new Cell(3,1, 19));
        assertThat(matrix.getCell(20)).isEqualToComparingFieldByField(new Cell(4,1, 20));
        assertThat(matrix.getCell(21)).isEqualToComparingFieldByField(new Cell(5,1, 21));
        assertThat(matrix.getCell(22)).isEqualToComparingFieldByField(new Cell(5,2, 22));
        assertThat(matrix.getCell(23)).isEqualToComparingFieldByField(new Cell(5,3, 23));
    }

    @Test
    public void calculatePart1() {
        int puzzleInput = 265149;
        Matrix matrix = new Day3().calculatePart1(puzzleInput);
        assertThat(getManhattanDistance(matrix.getCell(1), matrix.getCell(puzzleInput))).isEqualTo(438);
    }

    @Test
    public void testPart2() {
        int puzzleInput = 806;
        Matrix matrix = new Day3().calculatePart2(puzzleInput);
        assertThat(matrix.getCell(15,15).getValue()).isEqualTo(1);
        assertThat(matrix.getCell(15,16).getValue()).isEqualTo(1);
        assertThat(matrix.getCell(14,16).getValue()).isEqualTo(2);
        assertThat(matrix.getCell(14,15).getValue()).isEqualTo(4);
        assertThat(matrix.getCell(14,14).getValue()).isEqualTo(5);
        assertThat(matrix.getFirstValueHigherThan( 747)).isEqualTo(806);
    }

    @Test
    public void calculatePart2() {
        int puzzleInput = 265149;
        Matrix matrix = new Day3().calculatePart2(puzzleInput);
        assertThat(matrix.getFirstValueHigherThan(puzzleInput)).isEqualTo(266330);
    }

    private int getManhattanDistance(Cell c1, Cell c2) {
        return abs(c1.getX()-c2.getX()) + abs(c1.getY()-c2.getY());
    }

}