package domain;

class ManathanDistance {
    private final int value;

    int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ManathanDistance{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManathanDistance that = (ManathanDistance) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    ManathanDistance(int value) {

        this.value = value;
    }
}
