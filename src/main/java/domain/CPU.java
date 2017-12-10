package domain;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CPU {

    List<Register> registers;
    private int highestValue;

    CPU() {
        registers = new ArrayList<Register>();
        highestValue = 0;
    }

    public int getHighestValue() {
        return highestValue;
    }

    List<String> parse(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        List<String> instructions = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                instructions.add(scanner.nextLine());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return instructions;
    }

    void execute(String filename) {
        for (String instruction : parse(filename)) {
            executeInstruction(instruction);
        }
    }

    void executeInstruction(String instruction) {
        String[] tokens = instruction.split("\\s");
        String registerName = tokens[0];
        String operationToken = tokens[1];
        int operationValue = Integer.parseInt(tokens[2]);
        String registerConditionName = tokens[4];
        String conditionToken = tokens[5];
        int conditonValue = Integer.parseInt(tokens[6]);


        Register register = get(registerName);
        Operation operation = OperationFactory.create(operationToken, operationValue);
        Register registerCondition = get(registerConditionName);
        Condition condition = ConditionFactory.create(conditionToken, registerCondition.getValue(), conditonValue);


        if (condition.apply()) {
            register.setValue(operation.execute(register.getValue()));
            if (register.getValue() > highestValue) {
                highestValue = register.getValue();
            }
        }

    }

    Register get(String name) {
        Optional<Register> first = registers.stream().filter(register -> register.getName().equals(name)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        Register register = new Register(name);
        registers.add(register);
        return  register;
    }


    public int getLargestRegisterValue() {
       return registers.stream().mapToInt(Register::getValue).max().getAsInt();
    }
}
