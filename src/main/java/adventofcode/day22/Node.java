package adventofcode.day22;

import adventofcode.util.Point;

public class Node extends Point {
    private char value;

    public Node(int x, int y) {
        super(x, y);
    }

    public Node(int x, int y, char value) {
        super(x, y);
        this.value = value;
    }

    boolean isInfected() {
        return this.value == '#';
    }

    public boolean isClean() {
        return value=='.';
    }

    public boolean isFlagged() {
        return value=='F';
    }

    public boolean isWeakened() {
        return value=='W';
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean switchState() {
        if (value=='#') {
            value='.';
            return false;
        }else{
            value='#';
            return true;
        }
    }

    public boolean switchStatePart2() {
        if (isClean()) {
            this.value='W';
            return false;
        } else if (isWeakened()) {
            this.value='#';
            return true;
        } else if (isInfected()) {
            this.value='F';
            return false;
        } else if (isFlagged()) {
            this.value='.';
            return false;
        }
        return false;
    }

}
