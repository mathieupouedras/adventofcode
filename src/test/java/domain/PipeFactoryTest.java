package domain;

import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PipeFactoryTest {

    @Test
    public void should_create_one_pipe() {
        Pipe pipe23 = new Pipe(0, 2);
        List<Pipe> pipes = new ArrayList<>();
        pipes.add(pipe23);

        List<Pipe> pipe = PipeFactory.create("0 <-> 2");

        assertThat(pipe, is(pipes));
    }

    @Test
    public void should_create_3_pipes() {
        Pipe pipe20 = new Pipe(2, 0);
        Pipe pipe23 = new Pipe(2, 3);
        Pipe pipe24 = new Pipe(2, 4);

        List<Pipe> pipes = PipeFactory.create("2 <-> 0, 3, 4");

        assertThat(pipes.size(), is(3));
        assertThat(pipes.get(0), is(pipe20));
        assertThat(pipes.get(1), is(pipe23));
        assertThat(pipes.get(2), is(pipe24));
    }

}