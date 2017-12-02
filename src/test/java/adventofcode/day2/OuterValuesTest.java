package adventofcode.day2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class OuterValuesTest {

    private OuterValues outerValues = new OuterValues();

    @Test
    public void test1() {
        outerValues.apply(5);
        outerValues.apply(1);
        outerValues.apply(9);
        outerValues.apply(5);

        assertThat(outerValues.getMin()).isEqualTo(1);
        assertThat(outerValues.getMax()).isEqualTo(9);
    }

}