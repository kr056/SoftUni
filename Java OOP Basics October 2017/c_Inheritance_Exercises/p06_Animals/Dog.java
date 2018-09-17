package c_Inheritance_Exercises.p06_Animals;

public class Dog extends Animal {
     Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "BauBau";
    }
}
