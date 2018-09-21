package a_InterfacesAndAbstraction.Exercises.p10_mood3;

public class Demon extends BaseGameObject {

    private double energy;

    public Demon(String name, int level, double energy) {
        super(name, level);
        this.energy = energy;
    }

    public void hashPassword() {
        String result = Integer.toString(super.getName().length() * 217);

        this.setHashedPassword(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("\"%s\" | \"%s\" -> Demon%n"
                , super.getName(), super.getHashedPassword()));
        sb.append(String.format("%.1f%n", super.getLevel() * this.energy));

        return sb.toString();
    }
}
