package adventofcode.day8;

public enum Operator {
    INC,DEC;

    Operator forValue(String value) {
        if (value.equals("inc")) {
            return INC;
        }else if (value.equals("dec")) {
            return DEC;
        }else {
            throw new IllegalArgumentException("Unknown operator " + value);
        }
    }
}
