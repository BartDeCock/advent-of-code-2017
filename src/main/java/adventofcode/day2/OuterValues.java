package adventofcode.day2;

import java.util.List;

public class OuterValues {
    private Integer min = Integer.MAX_VALUE;
    private Integer max = 0;

    OuterValues() {
    }

    public OuterValues(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    void apply(Integer value) {
        if (value < min) min = value;
        if (value > max) max = value;
    }

    static OuterValues from(List<Integer> values) {
        OuterValues result = new OuterValues();
        values.forEach(result::apply);
        return result;
    }

    Integer getMin() {
        return min;
    }

    Integer getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "OuterValues{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

    Integer getDifference() {
        return max - min;
    }

    Integer getDivision() {
        return max / min;
    }
}
