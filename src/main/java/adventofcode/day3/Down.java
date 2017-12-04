package adventofcode.day3;

public class Down implements Step {
    private Cell currentCell;

    public Down(Cell currentCell) {
        this.currentCell = currentCell;
    }

    @Override
    public Cell calculateCoordinates() {
        currentCell =new Cell(currentCell.getX()+1, currentCell.getY(), currentCell.getValue()+1);
        return currentCell;
    }

    @Override
    public Step nextStep() {
        return new Right(currentCell);
    }
}
