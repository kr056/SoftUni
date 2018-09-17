package PolymorphismExercises.p03_WildFarm.Animals;


public class Zebra extends Mammal {
    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
