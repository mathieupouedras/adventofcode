package domain;

class Pipe {
    private final int firstProgramId;
    private final int secondProgramId;

    Pipe(int firstProgramId, int secondProgramId) {
        this.firstProgramId = firstProgramId;
        this.secondProgramId = secondProgramId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pipe pipe = (Pipe) o;

        return pipe.firstProgramId == this.firstProgramId | pipe.firstProgramId == this.secondProgramId;
    }

    @Override
    public int hashCode() {
        return 31 + (firstProgramId + 7) * (secondProgramId + 7);
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "firstProgramId=" + firstProgramId +
                ", secondProgramId=" + secondProgramId +
                '}';
    }
}
