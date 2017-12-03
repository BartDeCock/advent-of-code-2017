package adventofcode.day3;

import java.util.Map;

public class Right implements Step {
    private Cell currentCell;

    public Right(Cell currentCell) {
        this.currentCell = currentCell;
    }

    @Override
    public Cell calculateCoordinates() {
        currentCell = new Cell(currentCell.getX(), currentCell.getY()+1, currentCell.getValue()+1);
        return currentCell;
    }

    @Override
    public Cell calculateCellValue(Map<Integer, Cell> cells) {
        int sum = 0;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
//                sum = sum + cells.get
            }
        }

        return null;
    }

    @Override
    public Step nextStep() {
        return new Up(currentCell);
    }

}
