package domain;

import java.math.BigInteger;

final class Factor {
    private final BigInteger value;

    Factor(BigInteger value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factor factor = (Factor) o;

        return value != null ? value.equals(factor.value) : factor.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    BigInteger getValue() {
        return value;
    }
}
