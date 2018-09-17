package PawInc;

import PawInc.Animals.Cat;
import PawInc.Animals.Dog;
import PawInc.Centers.AdoptionCenter;
import PawInc.Centers.CastrationCenter;
import PawInc.Centers.CleansingCenter;

public class Factory {
    public static AdoptionCenter createAdoptionCenter(String name) {
        return new AdoptionCenter(name);
    }

    public static CleansingCenter createCleansingCenter(String name) {
        return new CleansingCenter(name);
    }

    public static CastrationCenter createCastrationCenter(String name) {
        return new CastrationCenter(name);
    }

    public static Dog createDog(String name, int age, int learnedCommands) {
        return new Dog(name, age, learnedCommands);
    }

    public static Cat createCat(String name, int age, int iq) {
        return new Cat(name, age, iq);
    }
}
