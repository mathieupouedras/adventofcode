package domain;

public class OperationDEC implements Operation {
    @Override
    public int execute(int input, int value) {
        return input - value;
    }
}
