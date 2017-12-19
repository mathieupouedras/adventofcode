package domain;

import java.util.ArrayList;
import java.util.List;

class Spin implements Dance {
    private final int moves;

    public Spin(int moves) {
        this.moves = moves;
    }

    @Override
    public void execute(List<Program> programs) {
        List<Program > result = new ArrayList<>();
        for (int i = 0; i < moves; i++) {
            result.add(programs.get(programs.size() - moves + i));
        }

        for (int i = 0; i < programs.size() - moves; i++) {
            result.add(programs.get(i));
        }

        programs.clear();
        programs.addAll(result);
    }

    @Override
    public String toString() {
        return "Spin{" +
                "moves=" + moves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spin spin = (Spin) o;

        return moves == spin.moves;
    }

    @Override
    public int hashCode() {
        return moves;
    }
}
