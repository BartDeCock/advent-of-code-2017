package adventofcode.day3;

import java.util.Map;

public interface Step {
    Cell calculateCoordinates();

    Cell calculateCellValue(Map<Integer, Cell> cells);

    Step nextStep();
}
