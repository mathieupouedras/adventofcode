package domain;

public class AbstractCondition {
    final int firstOperand;
    final int secondOperand;

    public AbstractCondition(int firstOperand, int secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public String toString() {
        return  getClass().getName() + "{" +
                "firstOperand=" + firstOperand +
                ", secondOperand=" + secondOperand +
                '}';
    }
}
