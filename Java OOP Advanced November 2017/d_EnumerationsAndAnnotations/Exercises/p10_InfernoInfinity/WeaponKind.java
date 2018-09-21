package d_EnumerationsAndAnnotations.Exercises.p10_InfernoInfinity;

public enum WeaponKind {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private int minDmg;
    private int maxDmg;
    private int socketsCount;

    WeaponKind(int minDmg, int maxDmg, int socketsCount) {
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.socketsCount = socketsCount;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public int getSocketsCount() {
        return socketsCount;
    }
}
