package PawInc.Animals;

public class Cat extends Animal {
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public int getIntelligenceCoefficient() {
        return intelligenceCoefficient;
    }
}