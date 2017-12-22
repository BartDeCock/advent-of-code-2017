package adventofcode.util;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public Direction turnLeft() {
        switch (this) {
            case UP: return LEFT;
            case DOWN: return RIGHT;
            case LEFT: return DOWN;
            case RIGHT: return UP;
            default: throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP: return RIGHT;
            case DOWN: return LEFT;
            case LEFT: return UP;
            case RIGHT: return DOWN;
            default: throw new IllegalStateException();
        }
    }

    public Direction reverse() {
        switch (this) {
            case UP: return DOWN;
            case DOWN: return UP;
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            default: throw new IllegalStateException();
        }
    }
}
