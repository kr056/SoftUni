package EncapsulationLab.p02_SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            this.salary = salary + (salary * (bonus / 200));
        } else {
            this.salary = salary + (salary * (bonus / 100));
        }
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " gets " + this.salary + " leva";
    }

}
