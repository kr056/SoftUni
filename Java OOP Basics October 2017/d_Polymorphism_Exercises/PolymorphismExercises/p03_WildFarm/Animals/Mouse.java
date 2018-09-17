package PolymorphismExercises.p03_WildFarm.Animals;

public class Mouse extends Mammal {
    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
