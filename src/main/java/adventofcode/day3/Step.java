package adventofcode.day3;

import adventofcode.util.Cell;

public interface Step {
    Cell calculateCoordinates();

    default Cell calculateCellValue(Matrix matrix) {
        Cell cell = calculateCoordinates();
        cell.setValue(0);
        int sum = 0;
        for (int x=-1; x<=1; x++) {
            for (int y=-1; y<=1; y++) {
                sum = sum + matrix.getCell(cell.getX()+x,cell.getY()+y).getValue();
            }
        }
        cell.setValue(sum);
        return cell;
    }

    Step nextStep();
}
