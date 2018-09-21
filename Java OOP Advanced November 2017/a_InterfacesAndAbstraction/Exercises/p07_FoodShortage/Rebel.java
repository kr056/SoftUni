package a_InterfacesAndAbstraction.Exercises.p07_FoodShortage;

public class Rebel extends BasePerson implements Buyer {
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
