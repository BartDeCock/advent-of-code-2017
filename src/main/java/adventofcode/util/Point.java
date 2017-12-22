package adventofcode.util;

public class Point {
    protected int x=0;
    protected int y=0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point next(Direction direction) {
        switch (direction) {
            case RIGHT: return new Point(x+1,y);
            case LEFT: return new Point(x-1,y);
            case DOWN: return new Point(x,y+1);
            case UP: return new Point(x,y-1);
            default: throw new IllegalStateException("Unknonw direcion " + direction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
