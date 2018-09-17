package EncapsulationExercises.p05_PizzaCalories;

import java.util.Arrays;
import java.util.List;

class Dough {
    private static final double WHITE = 1.5;
    private static final double WHOLEGRAIN = 1.0;
    private static final double CRISPY = 0.9;
    private static final double CHEWY = 1.1;
    private static final double HOMEMADE = 1.0;

    private List<String> dough = Arrays.asList("white", "wholegrain", "crispy", "chewy", "homemade");

    private String flourType;
    private String bakingTech;
    private double weightInGrams;

    Dough(String flourType, String bakingTech, double weightInGrams) {
        this.setFlourType(flourType);
        this.setBakingTech(bakingTech);
        this.setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        if (!dough.contains(flourType.toLowerCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTech(String bakingTech) {
        if (!dough.contains(bakingTech.toLowerCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTech = bakingTech;
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weightInGrams = weightInGrams;
    }

    double getDoughCalories() {
        double floursCal = getModifiersCal(this.flourType);
        double bakeCal = getModifiersCal(this.bakingTech);
        return (weightInGrams * 2) * floursCal * bakeCal;
    }

    private double getModifiersCal(String flourType) {
        switch (flourType.toLowerCase()) {
            case "wholegrain":
                return WHOLEGRAIN;
            case "white":
                return WHITE;
            case "chewy":
                return CHEWY;
            case "crispy":
                return CRISPY;
            case "homemade":
                return HOMEMADE;
            default:
                return 0;
        }
    }
}
