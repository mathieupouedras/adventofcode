package domain;

public class OperationDEC implements Operation {
    private final int value;

    public OperationDEC(int value) {
        this.value = value;
    }

    @Override
    public int execute(int input) {
        return input - value;
    }
}
