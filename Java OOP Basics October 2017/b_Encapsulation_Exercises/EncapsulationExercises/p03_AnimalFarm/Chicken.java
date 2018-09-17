package EncapsulationExercises.p03_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public void setName(String name) {
        if (name.length() < 1 || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    double productPerDay() {
        int total = this.age;
        double eggs = 0;

        if (total < 6) {
            return 2;
        } else if (total < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }
}
