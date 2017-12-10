package domain;

public class ConditionGreaterOrEqualThan extends AbstractCondition implements Condition {
    public ConditionGreaterOrEqualThan(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public boolean apply() {
        return firstOperand >= secondOperand;
    }
}
