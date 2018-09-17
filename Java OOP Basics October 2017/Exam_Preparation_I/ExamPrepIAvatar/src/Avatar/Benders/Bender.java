package Avatar.Benders;

public abstract class Bender {
    private String name;
    private int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    protected String getName() {
        return name;
    }

    protected int getPower() {
        return power;
    }

    public abstract double getBenderPower();
}
