package domain;

class Match {
    private final int value;

    Match(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        return value == match.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Match{" +
                "value=" + value +
                '}';
    }
}
