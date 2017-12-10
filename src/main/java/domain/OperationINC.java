package domain;

public class OperationINC implements Operation {
    private final int value;

    public OperationINC(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OperationINC{" +
                "value=" + value +
                '}';
    }

    @Override
    public int execute(int input) {
        return input + value;
    }
}
