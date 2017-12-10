package domain;

public class operationINC implements Operation {
    private final int value;

    public operationINC(int value) {
        this.value = value;
    }

    @Override
    public int execute(int input) {
        return input + value;
    }
}
