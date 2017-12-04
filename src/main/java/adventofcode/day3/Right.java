package adventofcode.day3;

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
    public Step nextStep() {
        return new Up(currentCell);
    }

}
