package c_Inheritance_Exercises.p06_Animals;

public class Tomcat extends Cat {

    Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }

}
