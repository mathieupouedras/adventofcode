package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceGenerator {
    private final String input;
    
    public SequenceGenerator(String input) {
        this.input = input;
    }

    public List<Integer> convertASCII() {
        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            sequence.add((int) input.charAt(i));
        }

        return sequence;

    }

    public List<Integer> getSequence() {
        List<Integer> result = convertASCII();
        result.addAll(Arrays.asList(17,31,73,47,23));
        return result;
    }

}
