package domain;

import java.util.List;

public class Program {
    private final String name;
    private final int weight;
    private final List<String> aboveProgramsName;

    public Program(String name, int weight, List<String> aboveProgramsName) {
        this.name = name;
        this.weight = weight;
        this.aboveProgramsName = aboveProgramsName;
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
                ", aboveProgramsName=" + aboveProgramsName +
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
}

