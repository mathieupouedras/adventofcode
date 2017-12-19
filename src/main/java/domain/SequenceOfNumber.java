package domain;

import java.math.BigInteger;

final class SequenceOfNumber {

    private final BigInteger value;

    public SequenceOfNumber(BigInteger startingValue) {
        this.value = startingValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceOfNumber that = (SequenceOfNumber) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    BigInteger getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SequenceOfNumber{" +
                "value=" + value +
                '}';
    }

}
