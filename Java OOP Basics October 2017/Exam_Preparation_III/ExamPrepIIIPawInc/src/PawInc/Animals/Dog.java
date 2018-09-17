package PawInc.Animals;

public class Dog extends Animal {
    private int ammountOfCommands;

    public Dog(String name, int age, int ammountOfCommands) {
        super(name, age);
        this.ammountOfCommands = ammountOfCommands;
    }

    public int getAmmountOfCommands() {
        return ammountOfCommands;
    }
}
