package adventofcode.day8;

public enum Comparator {
    EQUALS,NOT_EQUALS,LESS,GREATER, LESS_OR_EQUALS, GREATER_OR_EQUALS;

    static Comparator forValue(String comparator) {
        if (comparator.equals("==")) {
            return EQUALS;
        }
        if (comparator.equals("!=")) {
            return NOT_EQUALS;
        }
        if (comparator.equals("<=")) {
            return LESS_OR_EQUALS;
        }
        if (comparator.equals(">=")) {
            return GREATER_OR_EQUALS;
        }
        if (comparator.equals("<")) {
            return LESS;
        }
        if (comparator.equals(">")) {
            return GREATER;
        }
        return null;
    }
}
