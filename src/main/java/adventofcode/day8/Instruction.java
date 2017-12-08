package adventofcode.day8;

public class Instruction {
    private String id;
    private Operator operator;
    private Integer value;
    private Condition condition;

    public Instruction(String id, String operator, String value, String registerId, String comparator, String conditionValue) {
        this.id = id;
        this.operator = Operator.valueOf(operator.toUpperCase());
        this.value = Integer.valueOf(value);
        this.condition = new Condition(registerId, Comparator.forValue(comparator), Integer.valueOf(conditionValue));
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id='" + id + '\'' +
                ", operator=" + operator +
                ", value=" + value +
                ", condition=" + condition +
                '}';
    }

    int execute(int value, int conditionValue) {
        if (condition.isSuccess(conditionValue)) {
            System.out.println("Condition succuss for " + this);
            switch (operator) {
                case DEC: return value - this.value;
                case INC: return value + this.value;
            }
        }
        System.out.println("Condition no success for " + this);
        return value;
    }

    public String getId() {
        return id;
    }

    public Condition getCondition() {
        return condition;
    }
}
