package domain;

public class operationINC implements Operation {
    @Override
    public int execute(int input, int value) {
        return input + value;
    }
}
