package c_IteratorsAndComparators.Exercises.p05_ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person p) {
        if (this.name.compareTo(p.getName()) == 0) {
            if (Integer.compare(this.getAge(), p.getAge()) == 0) {
                return this.town.compareTo(p.getTown());
            } else {
                return Integer.compare(this.getAge(), p.getAge());
            }
        } else {
            return this.name.compareTo(p.getName());
        }
    }
}
