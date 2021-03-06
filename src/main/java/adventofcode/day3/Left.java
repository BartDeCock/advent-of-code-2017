package adventofcode.day3;

import adventofcode.util.Cell;

public class Left implements Step {
    private Cell currentCell;

    public Left(Cell currentCell) {
        this.currentCell = currentCell;
    }

    @Override
    public Cell calculateCoordinates() {
        currentCell =new Cell(currentCell.getX(), currentCell.getY()-1, currentCell.getValue()+1);
        return currentCell;
    }

    @Override
    public Step nextStep() {
        return new Down(currentCell);
    }
}
