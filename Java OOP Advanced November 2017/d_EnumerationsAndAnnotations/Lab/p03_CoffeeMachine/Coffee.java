package d_EnumerationsAndAnnotations.Lab.p03_CoffeeMachine;

public class Coffee {
    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public CoffeeSize getCoffeeSize() {
        return coffeeSize;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    @Override
    public String toString() {
        return this.coffeeSize.name().charAt(0) + this.coffeeSize.name().substring(1).toLowerCase()
                + " "
                + this.coffeeType.name().charAt(0) + this.coffeeType.name().substring(1).toLowerCase();
    }
}
