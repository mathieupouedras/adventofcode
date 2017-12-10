package domain;

public class OperationFactory {

    static Operation create(String operation, int value) {
        switch (operation) {
            case "inc": return new OperationINC(value);
            case "dec": return new OperationDEC(value);
            default: throw new IllegalArgumentException(String.format("No operation for %s", operation));
        }
    }
}
