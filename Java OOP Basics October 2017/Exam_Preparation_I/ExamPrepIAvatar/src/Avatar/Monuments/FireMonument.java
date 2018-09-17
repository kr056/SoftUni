package Avatar.Monuments;

public class FireMonument extends Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###Fire Monument: %s, Fire Affinity: %d", super.getName(), this.fireAffinity));
        return sb.toString();
    }

    @Override
    public int getMonPower() {
        return this.fireAffinity;
    }
}
