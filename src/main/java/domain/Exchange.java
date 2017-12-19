package domain;

import java.util.Collections;
import java.util.List;

class Exchange implements Dance {
    private final int firstPosition;
    private final int secondPosition;

    public Exchange(int firstPosition, int secondPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    @Override
    public void execute(List<Program> programs) {
        Program firstProgram = programs.get(firstPosition);
        Program secondProgram = programs.get(secondPosition);

        programs.set(firstPosition, secondProgram);
        programs.set(secondPosition, firstProgram);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchange exchange = (Exchange) o;

        if (firstPosition != exchange.firstPosition) return false;
        return secondPosition == exchange.secondPosition;
    }

    @Override
    public int hashCode() {
        int result = firstPosition;
        result = 31 * result + secondPosition;
        return result;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "firstPosition=" + firstPosition +
                ", secondPosition=" + secondPosition +
                '}';
    }
}
