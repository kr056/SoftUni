package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

public class Private extends Soldier implements IPrivate {
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%n",
                this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));

        return sb.toString();
    }
}
