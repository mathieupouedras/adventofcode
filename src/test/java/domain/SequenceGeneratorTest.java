package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SequenceGeneratorTest {

    @Test
    public void should_return_sequence_with_ascii_code() {

        SequenceGenerator sequenceGenerator = new SequenceGenerator("1,2,3");

        assertThat(sequenceGenerator.convertASCII(), is(Arrays.asList(49,44,50,44,51)));
    }

    @Test
    public void should_return_sequence_() {

        SequenceGenerator sequenceGenerator = new SequenceGenerator("1,2,3");

        assertThat(sequenceGenerator.getSequence(), is(Arrays.asList(49,44,50,44,51,17,31,73,47,23)));
    }
}
