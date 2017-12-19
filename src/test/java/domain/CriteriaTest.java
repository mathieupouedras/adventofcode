package domain;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CriteriaTest {

    @Test
    public void should_match_for_value_that_is_multiple_of_4() {
        Criteria criteriaA = new CriteriaA();

        assertThat(criteriaA.matches(new SequenceOfNumber(BigInteger.valueOf(16))), is(true));
    }

    @Test
    public void should_not_match_for_value_that_is_not_multiple_of_4() {
        Criteria criteriaA = new CriteriaA();

        assertThat(criteriaA.matches(new SequenceOfNumber(BigInteger.valueOf(17))), is(false));
    }

    @Test
    public void should_match_for_value_that_is_multiple_of_8() {
        Criteria criteriaB = new CriteriaB();

        assertThat(criteriaB.matches(new SequenceOfNumber(BigInteger.valueOf(16))), is(true));
    }

    @Test
    public void should_not_match_for_value_that_is_not_multiple_of_8() {
        Criteria criteriaA = new CriteriaB();

        assertThat(criteriaA.matches(new SequenceOfNumber(BigInteger.valueOf(17))), is(false));
    }


}