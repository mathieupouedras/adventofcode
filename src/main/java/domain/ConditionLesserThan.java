package domain;

public class ConditionLesserThan extends AbstractCondition implements Condition {

    public ConditionLesserThan(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public boolean apply() {
        return firstOperand < secondOperand;
    }
}
