package PolymorphismExercises.p03_WildFarm.Animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    DecimalFormat df = new DecimalFormat("#.##");

    private String livingRegion;

    public Mammal(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s[%s, %s, %s, %d]%n", this.getClass().getSimpleName(), super.getAnimalName(), df.format(super.getAnimalWeight()), this.livingRegion, super.getFoodEaten()));
        return sb.toString();
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
