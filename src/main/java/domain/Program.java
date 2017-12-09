package domain;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private final String name;
    private final int weight;
    private final List<String> aboveProgramsName;
    private List<Program> abovePrograms;

    public Program(String name, int weight, List<String> aboveProgramsName) {
        this.name = name;
        this.weight = weight;
        this.aboveProgramsName = aboveProgramsName;
        this.abovePrograms = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Program) {
            Program program = (Program) obj;

            return program.name.equals(this.name) && program.weight == this.weight
                    && program.aboveProgramsName.equals(this.aboveProgramsName);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", programs=" + abovePrograms +
                '}';
    }

    public boolean isHoldingDisc() {
        return aboveProgramsName.size() > 0;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public List<String> getAboveProgramsName() {
        return aboveProgramsName;
    }

    public void addProgram(Program program) {
        abovePrograms.add(program);
    }

    public int getSubTowerWeight() {
        int towerWeight = weight;
        if (isHoldingDisc()) {
            for (Program aboveProgram: abovePrograms) {
                towerWeight += aboveProgram.getWeight();
            }

        }

        return towerWeight;
    }

    public List<Program> getAbovePrograms() {
        return abovePrograms;
    }
}

