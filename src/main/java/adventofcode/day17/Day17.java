package adventofcode.day17;

import java.util.ArrayList;
import java.util.List;

public class Day17 {

    private List<Integer> spin = new ArrayList<>();

    int calculatePart1(int step) {
        spin.add(0, 0);
        spin.add(1, 1);
        int currentSize = 2;
        int currentIndex = 1;
        int currentValue = 1;
        while (currentValue < 2018) {
            currentValue++;
            currentIndex = nextIndex(step, currentSize, currentIndex);
            spin.add(currentIndex, currentValue);
            currentSize++;
        }
        return spin.get(spin.indexOf(2017)+1);
    }

    int calculatePart2(int step) {
        int currentSize = 1;
        int currentIndex = 0;
        int currentValue = 0;
        int lastValueOnIndex1 = 0;
        while (currentValue < 50_000_000) {
            currentValue++;
            currentIndex = nextIndex(step, currentSize, currentIndex);
            if (currentIndex==1) {
                lastValueOnIndex1 = currentValue;
            }
            currentSize++;
        }
        return lastValueOnIndex1;
    }

    private int nextIndex(int step, int currentSize, int currentIndex) {
        int jump = step < currentSize ? step : step % currentSize;
        currentIndex = currentIndex + jump + 1;
        if (currentIndex > currentSize) currentIndex=currentIndex-currentSize;
        return currentIndex;
    }
}
