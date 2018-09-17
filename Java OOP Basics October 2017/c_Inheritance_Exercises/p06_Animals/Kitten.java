package c_Inheritance_Exercises.p06_Animals;

public class Kitten extends Cat {
    Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }

}
