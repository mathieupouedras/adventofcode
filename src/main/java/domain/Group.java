package domain;

import java.util.List;

class Group {

    private final List<Program> programs;

    Group(List<Program> programs) {
        this.programs = programs;
    }

    String getOrderStringRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Program program: programs) {
            stringBuilder.append(program.getName());
        }
        return stringBuilder.toString();
    }

    void execute(List<Dance> dances) {
        dances.stream().forEach(dance -> dance.execute(programs));
    }

}
