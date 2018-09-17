package DefiningClassesExercises.p11_CatLady;

public abstract class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.name;
    }
}
