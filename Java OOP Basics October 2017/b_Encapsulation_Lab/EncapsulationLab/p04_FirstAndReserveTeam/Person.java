package EncapsulationLab.p04_FirstAndReserveTeam;

class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    int getAge() {
        return age;
    }


    Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
}
