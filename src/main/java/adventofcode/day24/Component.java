package adventofcode.day24;

import adventofcode.util.Point;

public class Component extends Point {
    private int id;
    private boolean usedX, usedY;

    public Component(int id,int x, int y) {
        super(x, y);
        this.id = id;
    }

    public boolean hasZero() {
        return x == 0 || y == 0;
    }

    public void setUsed(int i) {
        if (x == i) usedX = true;
        else if (y == i) usedY = true;
        else throw new IllegalArgumentException("Unknown value " + i + " for component " + this);
    }

    public boolean match(Component other) {
        return (!usedX && (x == other.x || x == other.y)) ||
                (!usedY && (y == other.x || y == other.y));
    }

    public int getUnused() {
        return usedX ? y : x;
    }

    public int getSum() {
        return x+y;
    }

    @Override
    public String toString() {
        return "Comp"+id+"{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Component component = (Component) o;

        return id == component.id;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        return result;
    }

    public Component copy() {
        return new Component(id, x, y);
    }
}
