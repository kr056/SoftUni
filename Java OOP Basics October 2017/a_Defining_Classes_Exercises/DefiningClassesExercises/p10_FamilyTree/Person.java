package DefiningClassesExercises.p10_FamilyTree;

public class Person {
    private String firstName;
    private String lastName;
    private String date;

    public Person(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    String getDate() {
        return this.date;
    }

    String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getFullName(), this.date);
    }
}