package PawInc.Centers;

import PawInc.Animals.Animal;
import PawInc.Animals.Cat;
import PawInc.Animals.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    Center(String name) {
        this.name = name;
        this.storedAnimals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Animal> getStoredAnimals() {
        return Collections.unmodifiableList(this.storedAnimals);
    }

    public abstract String toString();

    public void addDog(Dog dog) {
        this.storedAnimals.add(dog);
    }

    public void addCat(Cat cat) {
        this.storedAnimals.add(cat);
    }

    public void addAnimalForCleaning(Animal animal) {
        this.storedAnimals.add(animal);
    }

    public void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public void cleanCenter() {
        this.storedAnimals.clear();
    }
}
