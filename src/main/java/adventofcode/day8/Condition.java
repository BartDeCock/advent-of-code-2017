package adventofcode.day8;

public class Condition {
    private String registerId;
    private Comparator comparator;
    private Integer value;

    public Condition(String registerId, Comparator comparator, Integer value) {
        this.registerId = registerId;
        this.comparator = comparator;
        this.value = value;
    }

    public String getRegisterId() {
        return registerId;
    }

    public boolean isSuccess(int conditionValue) {
        switch (comparator) {
            case LESS:
                return conditionValue < value;
            case EQUALS:
                return conditionValue == value;
            case GREATER:
                return conditionValue > value;
            case NOT_EQUALS:
                return conditionValue != value;
            case LESS_OR_EQUALS:
                return conditionValue <= value;
            case GREATER_OR_EQUALS:
                return conditionValue >= value;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "registerId='" + registerId + '\'' +
                ", comparator=" + comparator +
                ", value=" + value +
                '}';
    }

}
