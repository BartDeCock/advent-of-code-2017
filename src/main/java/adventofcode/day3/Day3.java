package adventofcode.day3;

import adventofcode.util.Cell;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

class Day3 {

    private Step step;

    Matrix calculatePart1(Integer given) {
        int matrixSize = calculateMatrixSize(given);
        int center = (matrixSize + 1) / 2; // location of number 1
        Matrix matrix = new Matrix(matrixSize+1);
        Cell c1 = new Cell(center, center, 1);
        matrix.add(c1);

        step = new Right(c1);
        matrix.add(step.calculateCoordinates());

        step = step.nextStep();
        matrix.add(step.calculateCoordinates());

        int numberOfSteps = 2;
        Cell lastAddedCell;
        do {
            lastAddedCell = executeTwice(matrix, numberOfSteps, given);
            numberOfSteps++;
        } while (lastAddedCell.getValue()<=given);
        return matrix;
    }

    private int calculateMatrixSize(Integer given) {
        int matrixSize = (int) ceil(sqrt(given));

        if (matrixSize % 2 == 0) matrixSize++; // matrix has to be uneven
        return matrixSize;
    }

    Matrix calculatePart2(int given) {
        int matrixSize = calculateMatrixSize(given);
        int center = (matrixSize + 1) / 2; // location of number 1
        Matrix matrix = new Matrix(matrixSize + 1);
        matrix.initAllZeros();
        Cell c1 = new Cell(center, center, 1);
        matrix.add(c1);

        step = new Right(c1);
        matrix.add(step.calculateCellValue(matrix));

        step = step.nextStep();
        matrix.add(step.calculateCellValue(matrix));

        int numberOfSteps = 2;
        Cell lastAddedCell;
        do {
            lastAddedCell = executeTwicePart2(matrix, numberOfSteps, given);
            numberOfSteps++;
        } while (lastAddedCell.getValue() <= given);
        return matrix;
    }

    private Cell executeTwice(Matrix matrix, int numberOfSteps, int max) {
        Cell lastAddedCell = null;
        for (int t = 1; t < 3; t++) {
            step = step.nextStep();
            for (int i = 0; i < numberOfSteps; i++) {
                lastAddedCell = step.calculateCoordinates();
                if (lastAddedCell.getValue() > max) {
                    break;
                }
                matrix.add(lastAddedCell);
            }
        }

        return lastAddedCell;
    }

    private Cell executeTwicePart2(Matrix matrix, int numberOfSteps, int max) {
        Cell lastAddedCell = null;
        for (int t = 1; t < 3; t++) {
            step = step.nextStep();
            for (int i = 0; i < numberOfSteps; i++) {
                lastAddedCell = step.calculateCellValue(matrix);
                matrix.add(lastAddedCell);
                if (lastAddedCell.getValue() > max) {
                    break;
                }
            }
        }

        return lastAddedCell;
    }
}
