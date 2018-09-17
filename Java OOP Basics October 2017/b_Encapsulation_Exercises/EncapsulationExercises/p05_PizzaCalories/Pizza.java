package EncapsulationExercises.p05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String pizzaName;
    private int numberOfToppings;
    private Dough dough;
    private List<Topping> toppings;

    Pizza(String pizzaName, int numberOfToppings) {
        this.setPizzaName(pizzaName);
        this.setNumberOfToppings(numberOfToppings);
    }

    Pizza(String pizzaName, int numberOfToppings, Dough dough) {
        this.setPizzaName(pizzaName);
        this.setNumberOfToppings(numberOfToppings);
        this.setDough(dough);
        this.toppings = new ArrayList<>();
    }

    private void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setPizzaName(String pizzaName) {
        if (pizzaName.trim().length() < 1 || pizzaName.length() > 15 || pizzaName.isEmpty()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.pizzaName = pizzaName;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.numberOfToppings = numberOfToppings;
    }

    void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    double getPizzaCal() {
        double toppingCal = 0;

        for (Topping topping : this.toppings) {
            toppingCal += topping.getToppingCal();
        }

        return toppingCal * 2 + this.dough.getDoughCalories();
    }

    String getPizzaName() {
        return pizzaName;
    }
}
