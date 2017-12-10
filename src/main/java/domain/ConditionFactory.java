package domain;

public class ConditionFactory {

    public static Condition create(String name, int firstOperand, int secondOperand) {
        switch (name) {
            case "==" : return new ConditionEqualTo(firstOperand, secondOperand);
            case "!=" : return new ConditionNotEqualTo(firstOperand, secondOperand);
            case "<" : return new ConditionLesserThan(firstOperand, secondOperand);
            case "<=" : return new ConditionLesserOrEqualThan(firstOperand, secondOperand);
            case ">" : return new ConditionGreaterThan(firstOperand, secondOperand);
            case ">=": return new ConditionGreaterOrEqualThan(firstOperand, secondOperand);
            default:  throw new IllegalArgumentException(String.format("Cannot find condition for %S", name));
        }
    }
}
