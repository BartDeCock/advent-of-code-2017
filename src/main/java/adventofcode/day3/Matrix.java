package adventofcode.day3;

import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private Cell[][] matrix;
    private Map<Integer, Cell> cells = new HashMap<>();

    public Matrix(Integer size) {
        matrix = new Cell[size][size];
    }

    public void add(Cell cell) {
//        System.out.println("Add cell " + cell);
        matrix[cell.getX()][cell.getY()] = cell;
        cells.put(cell.getValue(), cell);
    }

    public Cell getCell(Integer given) {
       return cells.get(given);
    }
}
