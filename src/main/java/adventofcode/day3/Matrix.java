package adventofcode.day3;

import adventofcode.util.Cell;

import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private Cell[][] matrix;
    private Map<Integer, Cell> cells = new HashMap<>();

    public Matrix(Integer size) {
        matrix = new Cell[size][size];
    }

    public void add(Cell cell) {
        matrix[cell.getX()][cell.getY()] = cell;
        cells.put(cell.getValue(), cell);
    }

    public Cell getCell(Integer given) {
        return cells.get(given);
    }

    public Cell getCell(int x, int y) {
        return matrix[x][y];
    }

    public void initAllZeros() {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                matrix[x][y] = new Cell(x, y, 0);
            }
        }
    }

    Integer getFirstValueHigherThan(int puzzleInput) {
        return cells.values().stream()
                .filter(cell -> cell.getValue() > puzzleInput)
                .map(cell -> cell.getValue())
                .sorted()
                .findFirst()
                .orElse(0);
    }
}
