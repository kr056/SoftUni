package DefiningClassesExercises.p11_CatLady;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibels);
    }
}
