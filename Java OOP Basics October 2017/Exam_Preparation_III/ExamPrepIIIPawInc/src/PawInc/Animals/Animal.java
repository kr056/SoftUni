package PawInc.Animals;

public abstract class Animal {
    private String name;
    private int age;
    private String cleansingStatus;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = "UNCLEANSED";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    public void cleanAnimal() {
        this.cleansingStatus = "CLEANSED";
    }
}
