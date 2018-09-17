package PolymorphismExercises.p03_WildFarm.Animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, double animalWeight,String livingRegion,String breed) {
        super(animalName, animalWeight,livingRegion);
        this.breed=breed;
    }

    @Override
    public void makeSound(){
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s[%s, %s, %s, %s, %d]%n", this.getClass().getSimpleName(), super.getAnimalName(),this.breed, df.format(super.getAnimalWeight()), super.getLivingRegion(),super.getFoodEaten()));
        return sb.toString();
    }
}
