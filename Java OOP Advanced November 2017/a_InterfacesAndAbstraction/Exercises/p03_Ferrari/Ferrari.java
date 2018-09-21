package a_InterfacesAndAbstraction.Exercises.p03_Ferrari;

public class Ferrari implements Driveable {

    private static final String FERRARI_MODEL = "488-Spider";
    private String name;

    public Ferrari(String name) {
        this.name = name;
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String brake() {
        return "Brakes!";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return FERRARI_MODEL;
    }
}
