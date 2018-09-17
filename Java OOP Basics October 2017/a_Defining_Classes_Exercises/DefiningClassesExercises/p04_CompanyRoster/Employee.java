package DefiningClassesExercises.p04_CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email = "n/a";
    private int age = -1;

    Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    Employee(String name, double salary, String position, String email) {
        this(name, salary, position);
        this.email = email;
    }

    Employee(String name, double salary, String position, int age) {
        this(name, salary, position);
        this.age = age;
    }

    Employee(String name, double salary, String position, String email, int age) {
        this(name, salary, position);
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
