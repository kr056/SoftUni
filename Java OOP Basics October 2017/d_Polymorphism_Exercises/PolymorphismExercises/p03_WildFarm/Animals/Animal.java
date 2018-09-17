package PolymorphismExercises.p03_WildFarm.Animals;

import PolymorphismExercises.p03_WildFarm.Foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public void makeSound() {

    }

    public void eat(Food food) {
        this.foodEaten = food.getQuantity();
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }
}
