package Avatar.Benders;

public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f", super.getName(), super.getPower(), this.heatAggression));
        return sb.toString();
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * this.heatAggression;
    }
}
