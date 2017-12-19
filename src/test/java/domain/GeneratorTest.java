package domain;

import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    private final Criteria DUMMY_CRITERIA = null;

    @Test
    public void should_generate_1092455() {
        SequenceOfNumber startingValue = new SequenceOfNumber(BigInteger.valueOf(65));
        Factor factor = new Factor(BigInteger.valueOf(16807));
        Generator generator = new Generator(startingValue, factor, DUMMY_CRITERIA);
        SequenceOfNumber firstSequenceOfNumber = new SequenceOfNumber(BigInteger.valueOf(1092455));

        assertThat(generator.generate(), is(firstSequenceOfNumber));
    }

    @Test
    public void should_generate_twice() {
        SequenceOfNumber startingValue = new SequenceOfNumber(BigInteger.valueOf(65));
        Factor factor = new Factor(BigInteger.valueOf(16807));
        Generator generator = new Generator(startingValue, factor, DUMMY_CRITERIA);
        SequenceOfNumber seconSequenceOfNumber = new SequenceOfNumber(BigInteger.valueOf(1181022009));

        generator.generate();

        assertThat(generator.generate(), is(seconSequenceOfNumber));

        BigInteger bigInteger = BigInteger.valueOf(1092455);


        assertThat(bigInteger.and(BigInteger.valueOf(0xFFFF)).toString(2), is("1010101101100111"));
    }

    @Test
    public void part1() {
        SequenceOfNumber startingValueA = new SequenceOfNumber(BigInteger.valueOf(679));
        Factor factorA = new Factor(BigInteger.valueOf(16807));
        Generator generatorA = new Generator(startingValueA, factorA, new CriteriaAlwaysTrue());

        SequenceOfNumber startingValueB = new SequenceOfNumber(BigInteger.valueOf(771));
        Factor factorB = new Factor(BigInteger.valueOf(48271));
        Generator generatorB = new Generator(startingValueB, factorB, new CriteriaAlwaysTrue());

        Judge  judge = new Judge(generatorA, generatorB);
        judge.consider(new Pair(40_000_000));

        assertThat(judge.getMatches(), is(new Match(626)));

    }

    @Test
    public void part2() {
        SequenceOfNumber startingValueA = new SequenceOfNumber(BigInteger.valueOf(679));
        Factor factorA = new Factor(BigInteger.valueOf(16807));
        Generator generatorA = new Generator(startingValueA, factorA, new CriteriaA());

        SequenceOfNumber startingValueB = new SequenceOfNumber(BigInteger.valueOf(771));
        Factor factorB = new Factor(BigInteger.valueOf(48271));
        Generator generatorB = new Generator(startingValueB, factorB, new CriteriaB());

        Judge  judge = new Judge(generatorA, generatorB);
        judge.consider(new Pair(5_000_000));

        assertThat(judge.getMatches(), is(new Match(306)));

    }
}
