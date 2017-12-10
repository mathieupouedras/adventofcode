package domain;

public class ConditionGreaterThan extends AbstractCondition implements Condition {


    public ConditionGreaterThan(int firstOperand, int secondOperand) {
      super(firstOperand, secondOperand);
    }

    @Override
    public boolean apply() {
       return firstOperand > secondOperand;
    }
}
