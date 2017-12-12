package adventofcode.day11;

import adventofcode.util.InputReader;

public class Day11 {

    private int n = 0;
    private int s = 0;
    private int ne = 0;
    private int nw = 0;
    private int se = 0;
    private int sw = 0;
    private int max = 0;

    Result calculatePart1(String filename) {
        String[] steps = new InputReader().getLinesAsString(filename).get(0).split(",");
        for (int i = 0; i < steps.length; i++) {
            if (steps[i].equals("n")) {
                if (s > 0) { // N + S = 0
                    s--;
                } else if (sw > 0) { // N + SW = NW
                    sw--;
                    nw++;
                } else if (se > 0) { // N + SE = NE
                    se--;
                    ne++;
                } else {
                    n++;
                }
                checkmax();
            }
            if (steps[i].equals("s")) {
                if (n > 0) { // N+S=0
                    n--;
                } else if (nw > 0) { // S+NW=SW
                    nw--;
                    sw++;
                } else if (ne > 0) { // S+NE=SE
                    ne--;
                    se++;
                } else {
                    s++;
                }
                checkmax();
            }
            if (steps[i].equals("ne")) {
                if (sw > 0) {
                    sw--;
                } else if (s > 0) {
                    s--;
                    se++;
                } else if (nw > 0) {
                    nw--;
                    n++;
                } else {
                    ne++;
                }
                checkmax();
            }
            if (steps[i].equals("nw")) {
                if (se > 0) {
                    se--;
                } else if (s > 0) {
                    s--;
                    sw++;
                } else if (ne > 0) {
                    ne--;
                    n++;
                } else {
                    nw++;
                }
                checkmax();
            }
            if (steps[i].equals("se")) {
                if (nw > 0) {
                    nw--;
                } else if (n > 0) {
                    n--;
                    ne++;
                } else if (sw > 0) {
                    sw--;
                    s++;
                } else {
                    se++;
                }
                checkmax();
            }
            if (steps[i].equals("sw")) {
                if (ne > 0) {
                    ne--;
                } else if (n > 0) {
                    n--;
                    nw++;
                } else if (se > 0) {
                    se--;
                    s++;
                } else {
                    sw++;
                }
                checkmax();
            }
        }
        return new Result(getTotal(), max);
    }

    private void checkmax() {
        if (getTotal() > max) max = getTotal();
    }

    int calculatePart2(String filename) {
        return calculatePart1(filename).max;
    }

    int getTotal() {
        return n + s + nw + ne + sw + se;
    }

    class Result {
        int totalSteps;
        int max;

        public Result(int totalSteps, int max) {
            this.totalSteps = totalSteps;
            this.max = max;
        }

        public int getTotalSteps() {
            return totalSteps;
        }
    }
}
