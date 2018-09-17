package PolymorphismExercises.p03_WildFarm.Animals;

public class Tiger extends Felime {
    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
