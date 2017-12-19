package domain;

class Program {
    private final String name;

    Program(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        return name != null ? name.equals(program.name) : program.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    String getName() {
        return name;
    }
}
