package adventofcode.day5;

import adventofcode.util.InputReader;

import java.util.List;

public class Day5 {

    private int currentStep;
    private int currentPosition;
    private int previousPosition;
    private int jump;
    private List<Integer> offsets;

    public int calculatePart1(String filename) {
        offsets = new InputReader().getLinesAsInteger(filename);
        currentStep = 1;
        currentPosition = 0;
        previousPosition = 0;
        jump = offsets.get(currentPosition);

        try {
            while (true) {
                takeStep();
            }
        } catch (IndexOutOfBoundsException e) {
            return currentStep;
        }
    }

    public int calculatePart2(String filename) {
        offsets = new InputReader().getLinesAsInteger(filename);
        currentStep = 1;
        currentPosition = 0;
        previousPosition = 0;
        jump = offsets.get(currentPosition);

        try {
            while (true) {
                takeStep();
            }
        } catch (IndexOutOfBoundsException e) {
            return currentStep;
        }
    }

    private void takeStep() {
        System.out.println("Taking step" + currentStep);
        // move to new position
        previousPosition = currentPosition;
        currentPosition = currentPosition + jump;

        // update previous value and jump
        if (jump >= 3) {
            offsets.set(previousPosition, offsets.get(previousPosition) - 1);
        } else {
            offsets.set(previousPosition, offsets.get(previousPosition) + 1);
        }
        jump = offsets.get(currentPosition);
        currentStep++;
    }

    private void print(List<Integer> offsets, int currentPosition, int previousPosition, int jump) {
        System.out.println("Offsets: " + offsets);
        System.out.println("currentPostion: " + currentPosition);
        System.out.println("PreviousPostion: " + previousPosition);
        System.out.println("Jump: " + jump);
    }
}
