package domain;

import org.junit.Test;
import sun.nio.cs.Surrogate;

import java.math.BigInteger;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Test
    public void should_generate_1092455() {
        SequenceOfNumber startingValue = new SequenceOfNumber(BigInteger.valueOf(65));
        Factor factor = new Factor(BigInteger.valueOf(16807));
        Generator generator = new Generator(startingValue, factor);
        SequenceOfNumber firstSequenceOfNumber = new SequenceOfNumber(BigInteger.valueOf(1092455));

        assertThat(generator.generate(), is(firstSequenceOfNumber));
    }

    @Test
    public void should_generate_twice() {
        SequenceOfNumber startingValue = new SequenceOfNumber(BigInteger.valueOf(65));
        Factor factor = new Factor(BigInteger.valueOf(16807));
        Generator generator = new Generator(startingValue, factor);
        SequenceOfNumber seconSequenceOfNumber = new SequenceOfNumber(BigInteger.valueOf(1181022009));

        generator.generate();

        assertThat(generator.generate(), is(seconSequenceOfNumber));

        BigInteger bigInteger = BigInteger.valueOf(1092455);

        System.out.println(bigInteger.shiftRight(bigInteger.bitCount() - 16).toString(2));
    }


}
