package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class ConditionTest {

    @Test
    public void should_return_true_when_2_greater_than_1() {
        Condition condition = new ConditionGreaterThan(2,1);

        assertThat(condition.apply(), is(true));
    }

    @Test
    public void should_return_true_when_5_lesser_than_8() {
        Condition condition = new ConditionLesserThan(5,8);

        assertThat(condition.apply(), is(true));
    }

    @Test
    public void should_return_true_when_2_greater_or_equal_than_2() {
        Condition condition = new ConditionGreaterOrEqualThan(2,2);

        assertThat(condition.apply(), is(true));
    }

    @Test
    public void should_return_true_when_2_lesser_or_equal_than_2() {
        Condition condition = new ConditionLesserOrEqualThan(2,2);

        assertThat(condition.apply(), is(true));
    }
}
