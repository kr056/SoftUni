package Avatar.Benders;

public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f", super.getName(), super.getPower(), this.groundSaturation));
        return sb.toString();
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * this.groundSaturation;
    }
}
