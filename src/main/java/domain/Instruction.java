package domain;

public class Instruction {
    private final Register register;
    private final Operation operation;
    private final Condition condition;

    public Instruction(Register register, Operation operation, Condition condition) {
        this.register = register;
        this.operation = operation;
        this.condition = condition;
    }
}
