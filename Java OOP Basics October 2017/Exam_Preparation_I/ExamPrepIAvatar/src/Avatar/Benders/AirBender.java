package Avatar.Benders;

public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Air Bender: %s, Power: %d, Aerial Integrity: %.2f", super.getName(), super.getPower(), this.aerialIntegrity));
        return sb.toString();
    }


    @Override
    public double getBenderPower() {
        return super.getPower() * this.aerialIntegrity;
    }
}
