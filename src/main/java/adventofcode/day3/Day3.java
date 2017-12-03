package adventofcode.day3;

import java.util.Map;

import static java.lang.Math.*;

public class Day3 {

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
//        while (currentCellId <= given) {
//            currentCellId = executeTwice(currentCellId, numberOfSteps);
//            numberOfSteps++;
//        }

        return matrix;
    }

    private int calculateMatrixSize(Integer given) {
        int matrixSize = (int) ceil(sqrt(given));

        if (matrixSize % 2 == 0) matrixSize++; // matrix has to be uneven
        return matrixSize;
    }

    Map<Integer, Cell> calculatePart2(int given) {
//        int center = initializeGrid(given);
//        initGridWithAllZeros(given);
//        Cell c1 = new Cell(center, center);
//        int currentCellId = 1;
//
//        cells.put(currentCellId, c1);
//        step = new Right(c1);
//
//        cells.put(++currentCellId, step.calculateCoordinates());
//
//        step = step.nextStep();
//        cells.put(++currentCellId, step.calculateCoordinates());
//
//        int numberOfSteps = 2;
//        while (currentCellId <= given) {
//            currentCellId = executeTwice(currentCellId, numberOfSteps);
//            numberOfSteps++;
//        }
//
//        System.out.println("Given cell: " + cells.get(given));
//
        return null;
    }

    private void initGridWithAllZeros(int given) {
//        for (int i=1; i<=given;i++) {
//            cells.put(i, new Cell(0,0));
//        }
    }

//    private int initializeGrid(Integer given) {
//        cells = new HashMap<>();
//        int matrixSize = (int) ceil(sqrt(given));
//
//        if (matrixSize % 2 == 0) matrixSize++; // matrix has to be uneven
//        int center = (matrixSize + 1) / 2; // location of number 1
//        System.out.println("Center: " + center);
//        return center;
//    }

//    private int executeTwice(int currentCellId, int numberOfSteps) {
//        for (int t=1; t<3; t++) {
//            step = step.nextStep();
//            for (int i = 0; i < numberOfSteps; i++) {
//                cells.put(++currentCellId, step.calculateCoordinates());
//            }
//        }
//        return currentCellId;
//    }

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

}
