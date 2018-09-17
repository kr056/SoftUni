package DefiningClassesExercises.p09_Google;

class Company {
    private String companyName;
    private String deparment;
    private double salary;

    Company(String companyName, String deparment, double salary) {
        this.companyName = companyName;
        this.deparment = deparment;
        this.salary = salary;
    }

    String getCompanyInfo() {
        return this.companyName + " " + this.deparment + " " + String.format("%.2f", this.salary);
    }
}
