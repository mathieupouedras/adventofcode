package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class OperationTest {

    @Test
    public void should_increment_value_by_5() {
        Operation operation = new OperationINC(5);

        assertThat(operation.execute(10), is(15));

    }

    @Test
    public void shoud_decrement_value_by_5() {
        Operation operation = new OperationDEC(5);

        assertThat(operation.execute(9), is(4));
    }
}
