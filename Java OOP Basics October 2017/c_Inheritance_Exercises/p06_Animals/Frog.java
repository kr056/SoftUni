package c_Inheritance_Exercises.p06_Animals;

public class Frog extends Animal {
    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
