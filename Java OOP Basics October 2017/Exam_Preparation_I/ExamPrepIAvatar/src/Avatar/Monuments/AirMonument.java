package Avatar.Monuments;

public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Air Monument: %s, Air Affinity: %d", super.getName(), this.airAffinity));
        return sb.toString();
    }

    @Override
    public int getMonPower() {
        return this.airAffinity;
    }
}
