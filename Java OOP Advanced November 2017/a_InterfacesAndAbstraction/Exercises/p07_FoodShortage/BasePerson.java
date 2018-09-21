package a_InterfacesAndAbstraction.Exercises.p07_FoodShortage;

public abstract class BasePerson implements Buyer {
    private String name;
    private int age;

    public BasePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
