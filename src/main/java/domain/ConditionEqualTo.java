package domain;

public class ConditionEqualTo extends AbstractCondition implements Condition {

    public ConditionEqualTo(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public boolean apply() {
        return firstOperand == secondOperand;
    }
}
