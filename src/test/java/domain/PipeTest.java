package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PipeTest {

    @Test
    public void should_return_true_when_comparing_symetric_pipes() {
        Pipe pipe12 = new Pipe(1, 2);
        Pipe pipe21 = new Pipe(2, 1);

        assertThat(pipe12.equals(pipe21), is(true));
    }

    @Test
    public void should_return_false_when_comparing_two_different_pipes() {
        Pipe pipe02 = new Pipe(0, 2);
        Pipe pipe11 = new Pipe(1, 1);

        assertThat(pipe02.equals(pipe11), is(false));
    }


    @Test
    public void should_return_different_hash() {
        Pipe pipe11 = new Pipe(1, 1);
        Pipe pipe20 = new Pipe(2, 0);

        assertThat(pipe11.hashCode() != pipe20.hashCode(), is(true));

    }

}