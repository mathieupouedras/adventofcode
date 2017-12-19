package domain;

import java.util.List;

class Partner implements Dance {

    private final String firstName;
    private final String secondName;

    @Override
    public String toString() {
        return "Partner{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partner partner = (Partner) o;

        if (firstName != null ? !firstName.equals(partner.firstName) : partner.firstName != null) return false;
        return secondName != null ? secondName.equals(partner.secondName) : partner.secondName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    public Partner(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;


    }

    @Override
    public void execute(List<Program> programs) {
        int firstPosition = programs.indexOf(new Program(firstName));
        int secondPosition = programs.indexOf(new Program(secondName));

        Program firstProgram = programs.get(firstPosition);
        Program secondProgram = programs.get(secondPosition);

        programs.set(firstPosition, secondProgram);
        programs.set(secondPosition, firstProgram);

    }
}
