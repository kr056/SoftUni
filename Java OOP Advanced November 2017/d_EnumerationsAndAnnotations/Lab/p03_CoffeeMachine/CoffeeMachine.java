package d_EnumerationsAndAnnotations.Lab.p03_CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coin> coins;
    private List<Coffee> boughtCoffees;

    public CoffeeMachine() {
        this.coins = new ArrayList<>();
        this.boughtCoffees = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());

        Coffee coffee = new Coffee(coffeeSize, coffeeType);

        if (this.coins.stream().mapToInt(Coin::getCoinValue).sum() >= coffee.getCoffeeSize().getPrice()) {
            this.boughtCoffees.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin) {
        this.coins.add(Coin.valueOf(coin.toUpperCase()));
    }

    public Iterable<Coffee> coffeesSold() {
        return this.boughtCoffees;
    }
}
