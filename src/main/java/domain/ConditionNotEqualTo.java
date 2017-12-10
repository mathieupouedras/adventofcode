package domain;

public class ConditionNotEqualTo extends AbstractCondition implements Condition {

    public ConditionNotEqualTo(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public boolean apply() {
        return firstOperand != secondOperand;
    }
}
