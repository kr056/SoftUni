package Avatar.Monuments;

public class EarthMonument extends Monument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Earth Monument: %s, Earth Affinity: %d", super.getName(), this.earthAffinity));
        return sb.toString();
    }

    @Override
    public int getMonPower() {
        return this.earthAffinity;
    }

}
