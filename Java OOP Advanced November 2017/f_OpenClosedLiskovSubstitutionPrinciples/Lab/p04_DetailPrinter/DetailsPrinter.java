package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p04_DetailPrinter;

public class DetailsPrinter {

    private Iterable<Employeable> employees;

    public DetailsPrinter(Iterable<Employeable> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employeable employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
