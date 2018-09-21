package c_IteratorsAndComparators.Exercises.p07_EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;

        return !(obj == null || obj.getClass() != this.getClass())
                && person.getName().equals(this.getName())
                && person.getAge() == (this.getAge());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() * this.age.hashCode();
    }

    @Override
    public int compareTo(Person p) {
        if (this.name.compareTo(p.getName()) == 0) {
            return Integer.compare(this.age, p.getAge());
        }

        return this.name.compareTo(p.getName());
    }
}
