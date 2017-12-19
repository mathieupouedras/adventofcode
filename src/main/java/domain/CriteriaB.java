package domain;

import java.math.BigInteger;

class CriteriaB implements Criteria {
    @Override
    public boolean matches(SequenceOfNumber sequenceOfNumber) {
        return sequenceOfNumber.getValue().mod(BigInteger.valueOf(8)).equals(BigInteger.ZERO);
    }
}
