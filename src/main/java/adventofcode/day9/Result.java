package adventofcode.day9;

public class Result {
    private int score;
    private int garbageCount;

    public Result(int score, int garbageCount) {
        this.score = score;
        this.garbageCount = garbageCount;
    }

    public int getGarbageCount() {
        return garbageCount;
    }

    public int getScore() {
        return score;
    }
}
