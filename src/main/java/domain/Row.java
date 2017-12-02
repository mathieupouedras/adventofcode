package domain;

import java.util.Arrays;

class Row {

    private int[] numbers;

    Row(String data) {
        String[] tokens = data.split("\\s");
        this.numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            this.numbers[i] = Integer.parseInt(tokens[i]);
        }
        Arrays.sort(numbers);
    }

    @Override
    public String toString() {
        return "Row{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    int getSmallestValue() {
        return numbers[0];
    }

    int getLargestValue() {
        return numbers[numbers.length - 1];
    }

    int checksum() {
        return getLargestValue() - getSmallestValue();
    }
}
