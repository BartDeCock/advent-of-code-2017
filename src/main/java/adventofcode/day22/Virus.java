package adventofcode.day22;

import adventofcode.util.Direction;
import adventofcode.util.Point;

public class Virus {
    private Node currentNode;
    private Direction currentDirection;

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void switchDirection() {
        if (currentNode.isInfected()) {
            currentDirection = currentDirection.turnRight();
        } else if (currentNode.isClean()) {
            currentDirection = currentDirection.turnLeft();
        } else if (currentNode.isFlagged()) {
            currentDirection = currentDirection.reverse();
        }
    }

    public boolean execute() {
        return currentNode.switchState();
    }

    public boolean executePart2() {
        return currentNode.switchStatePart2();
    }

    public Point move() {
        return currentNode.next(currentDirection);
    }
}
