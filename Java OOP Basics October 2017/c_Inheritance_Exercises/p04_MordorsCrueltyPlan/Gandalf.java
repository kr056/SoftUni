package c_Inheritance_Exercises.p04_MordorsCrueltyPlan;

import java.util.ArrayList;
import java.util.List;

class Gandalf {
    private List<Food> foods;
    private int happiness;
    private String mood;

    Gandalf() {
        this.foods = new ArrayList<>();
    }

    String getMood() {
        return calculateMood();
    }

    int getHappiness() {
        return calculateHappinessValue();
    }

    void addFood(Food food) {
        this.foods.add(food);
    }

    private String calculateMood() {
        if (this.happiness < -5) {
            return "Angry";
        } else if (this.happiness < 1) {
            return "Sad";
        } else if (this.happiness < 16) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }

    private int calculateHappinessValue() {
        for (Food food : this.foods) {
            this.happiness += getFoodValue(food);
        }
        return this.happiness;
    }

    private int getFoodValue(Food food) {
        switch (food.getName().toLowerCase()) {
            case "cram":
                return 2;
            case "lembas":
                return 3;
            case "apple":
                return 1;
            case "melon":
                return 1;
            case "honeycake":
                return 5;
            case "mushrooms":
                return -10;
            default:
                return -1;
        }
    }
}
