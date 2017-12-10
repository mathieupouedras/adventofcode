package domain;

public class ConditionLesserOrEqualThan extends AbstractCondition implements Condition {
    public ConditionLesserOrEqualThan(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public boolean apply() {
        return firstOperand <= secondOperand;
    }
}
