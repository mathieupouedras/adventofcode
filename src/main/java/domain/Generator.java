package domain;

import java.math.BigInteger;

class Generator {
    private SequenceOfNumber previsousValue;
    private final Factor factor;
    private final SequenceOfNumber divider = new SequenceOfNumber(BigInteger.valueOf(2147483647));
    private final Criteria criteria;

    Generator(SequenceOfNumber startingValue, Factor factor, Criteria criteria) {
        this.previsousValue = startingValue;
        this.factor = factor;
        this.criteria = criteria;
    }

    SequenceOfNumber generate() {
        previsousValue = new SequenceOfNumber(
                previsousValue.getValue().multiply(factor.getValue()).mod(divider.getValue()));
        return previsousValue;
    }

    boolean areLowest16bitsEqual(SequenceOfNumber sequenceOfNumber) {
        return false;
    }

    boolean isValueAvailable() {
        return criteria.matches(previsousValue);
    }
}
