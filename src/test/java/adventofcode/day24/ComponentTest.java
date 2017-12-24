package adventofcode.day24;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ComponentTest {
    private Component c1 = new Component(0,1,2);
    private Component c2 = new Component(1,2,3);
    private Component c3 = new Component(2,3,1);

    @Test
    public void match() {
        assertThat(c1.match(c2)).isTrue();
        assertThat(c1.match(c3)).isTrue();
        c1.setUsed(1);
        assertThat(c1.match(c3)).isFalse();
        assertThat(c1.match(c2)).isTrue();

    }

}