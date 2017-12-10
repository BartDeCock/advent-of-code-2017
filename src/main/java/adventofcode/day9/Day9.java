package adventofcode.day9;

import adventofcode.util.InputReader;

public class Day9 {
    public Result calculatePart1(String filename) {
        String input = new InputReader().getLinesAsString(filename).get(0);
        // remove cancelation chars
        String filteredCancelledChars = input.replaceAll("(!.)", "");
        // calculate score
        int score = 0;
        int depth = 1;
        boolean garbage = false;
        int garbageCount = 0;
        for (char c : filteredCancelledChars.toCharArray()) {
            if (garbage && c!='>') garbageCount++;
            else if (c == '<') garbage=true;
            else if (c == '>') garbage=false;
            else if (c=='{') score += depth++;
            else if (c=='}') depth--;
        }

        return new Result(score, garbageCount);
    }

    public Result calculatePart2(String filename) {
        return calculatePart1(filename);
    }
}
