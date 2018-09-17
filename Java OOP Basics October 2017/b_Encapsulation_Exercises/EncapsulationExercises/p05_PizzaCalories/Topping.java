package EncapsulationExercises.p05_PizzaCalories;

import java.util.Arrays;
import java.util.List;

class Topping {

    private static final double MEAT = 1.2;
    private static final double VEGGIES = 0.8;
    private static final double CHEESE = 1.1;
    private static final double SAUCE = 0.9;

    private List<String> topping = Arrays.asList("meat", "veggies", "cheese", "sauce");

    private String toppingType;
    private double weighInGrams;


    Topping(String toppingType, double weighInGrams) {
        this.setToppingType(toppingType);
        this.setWeighInGrams(weighInGrams);
    }

    private void setToppingType(String toppingType) {
        if (!topping.contains(toppingType.toLowerCase())) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.%n", toppingType));
        }

        this.toppingType = toppingType;
    }

    private void setWeighInGrams(double weighInGrams) {
        if (weighInGrams < 1 || weighInGrams > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].%n", this.toppingType));
        }

        this.weighInGrams = weighInGrams;
    }

    double getToppingCal() {
        double getModifierCal = getCal(this.toppingType);

        return getModifierCal * this.weighInGrams;
    }

    private double getCal(String toppingType) {
        switch (toppingType.toLowerCase()) {
            case "meat":
                return MEAT;
            case "veggies":
                return VEGGIES;
            case "cheese":
                return CHEESE;
            case "sauce":
                return SAUCE;
            default:
                return 0;
        }
    }

}
