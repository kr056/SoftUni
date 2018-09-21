package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p04_DetailPrinter;

public class Employee implements Employeable {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}
