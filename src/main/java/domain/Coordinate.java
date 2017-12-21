package domain;

final class Coordinate {
    private final int value;

    Coordinate(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "value=" + value +
                '}';
    }

    public Coordinate increase(Coordinate coordinate) {
        return new Coordinate(this.value + coordinate.getValue());
    }

}
