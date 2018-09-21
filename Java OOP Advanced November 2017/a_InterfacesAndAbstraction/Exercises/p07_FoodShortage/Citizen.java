package a_InterfacesAndAbstraction.Exercises.p07_FoodShortage;

public class Citizen extends BasePerson implements Buyer {
    private String id;
    private String birthdate;
    private int food;

    public Citizen(String name, int age, String id, String birthdate) {
        super(name, age);
        this.id = id;
        this.birthdate = birthdate;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
