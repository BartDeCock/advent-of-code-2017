package adventofcode.day3;

import java.util.Map;

public class Up implements Step {
    private Cell currentCell;

    public Up(Cell currentCell) {
        this.currentCell = currentCell;
    }

    @Override
    public Cell calculateCoordinates() {
        currentCell = new Cell(currentCell.getX() - 1, currentCell.getY(), currentCell.getValue()+1);
        return currentCell;
    }

    @Override
    public Cell calculateCellValue(Map<Integer, Cell> cells) {
        return null;
    }

    @Override
    public Step nextStep() {
        return new Left(currentCell);
    }
}
