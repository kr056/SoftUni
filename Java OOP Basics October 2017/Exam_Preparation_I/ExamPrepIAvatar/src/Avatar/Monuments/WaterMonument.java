package Avatar.Monuments;

public class WaterMonument extends Monument {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Water Monument: %s, Water Affinity: %d", super.getName(), this.waterAffinity));
        return sb.toString();
    }

    @Override
    public int getMonPower() {
        return this.waterAffinity;
    }
}
