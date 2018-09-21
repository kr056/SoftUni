package h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.models;

public class King extends BaseUnit {

    private static King instance = new King("");

    private King(String name) {
        super(name);
    }

    public static King getInstance() {
        return instance;
    }

    @Override
    public void respondToAttack() {
        System.out.println("King " + this.toString() + " is under attack!");
    }

    @Override
    public boolean tryToKill() {
        return false;
    }
}
