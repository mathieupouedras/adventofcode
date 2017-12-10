package domain;

public class Register {
    private int value;
    private final String name;

    public Register(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Register{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Register register = (Register) o;

        return name != null ? name.equals(register.name) : register.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
