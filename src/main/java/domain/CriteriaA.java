package domain;

import java.math.BigInteger;

class CriteriaA implements Criteria {
    @Override
    public boolean matches(SequenceOfNumber sequenceOfNumber) {
        return sequenceOfNumber.getValue().mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO);
    }
}
