package d_EnumerationsAndAnnotations.Lab.p02_WarningLevels;

public enum Importance {
    LOW(1), NORMAL(2), MEDIUM(3), HIGH(4);

    private int priority;

    Importance(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
