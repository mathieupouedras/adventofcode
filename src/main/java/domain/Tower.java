package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tower {

    private final List<Program> programs;

    public Tower(List<Program> programs) {
        this.programs = programs;
    }

    public Program getBottomProgram() {

        List<Program> programsHoldingDiscs = programs.stream().filter(Program::isHoldingDisc).collect(Collectors.toList());

        for (Program program : programsHoldingDiscs) {
            boolean isBottomProgram = true;
            for (Program subProgram : programsHoldingDiscs) {
                if (program.equals(subProgram)) {
                    continue;
                }
                if (subProgram.getAboveProgramsName().contains(program.getName())) {
                    isBottomProgram = false;
                }
            }
            if (isBottomProgram) {
                return program;
            }
        }
        throw new RuntimeException("Cannot find bottom program");
    }
}
