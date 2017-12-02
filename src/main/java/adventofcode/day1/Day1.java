package adventofcode.day1;

import adventofcode.util.StringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {
    private List<Integer> input = new ArrayList<>();
    private List<Integer> applicableNumbers = new ArrayList<>();

    Integer captcha(String input) {

        this.input = new StringConverter().convert(input, "\\d");

        int length = this.input.size();
        int step = length / 2;

        for (int index = 0; index < length; index++) {
            Integer current = this.input.get(index);
            boolean isEqual = current == this.input.get(index + step);
//            System.out.println("Comparing index " + index + " with index " + (index + step) + " -- " + isEqual);
            if (isEqual) {
                applicableNumbers.add(current);
            }

            if (index < step) {
                this.input.add(current);
            }
        }
        return applicableNumbers.stream().reduce((i1, i2) -> i1+i2).orElse(0);
    }


}
