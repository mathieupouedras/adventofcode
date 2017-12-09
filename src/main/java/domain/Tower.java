package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tower {

    public List<Program> getPrograms() {
        return programs;
    }

    private final List<Program> programs;

    public Tower(List<Program> programs) {
        this.programs = programs;
    }

    public void enrichProgram() {
        for (Program program : programs) {
            for (String aboveProgramName: program.getAboveProgramsName()) {
                program.addProgram(getProgram(aboveProgramName));
            }
        }
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

    public int submit() {
        Program bottomProgram = getBottomProgram();
        for (Program aboveProgram: bottomProgram.getAbovePrograms()) {
            System.out.println(aboveProgram.getSubTowerWeight());
        }

        return 0;
    }

    public int getBalancedWeight(Program program, int weight) {
        weight += program.getWeight();
        if (program.isHoldingDisc()) {
            for (String subProgramName : program.getAboveProgramsName()) {
                Program subProgram = getProgram(subProgramName);
                getBalancedWeight(subProgram, weight);
            }
        }
        return weight;
    }

    private Program getProgram(String programName) {
        for (Program program : programs) {
            if (program.getName().equals(programName)) {
                return program;
            }
        }
        throw new RuntimeException(String.format("Cannot Find program with name %s", programName));
    }
}
