package Avatar.Benders;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Water Bender: %s, Power: %d, Water Clarity: %.2f", super.getName(), super.getPower(), this.waterClarity));
        return sb.toString();
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * this.waterClarity;
    }
}
