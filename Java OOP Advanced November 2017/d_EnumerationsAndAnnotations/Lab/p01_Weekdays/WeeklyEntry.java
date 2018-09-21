package d_EnumerationsAndAnnotations.Lab.p01_Weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry> {
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    @Override
    public String toString() {
        return this.weekday.toString() + " - " + this.notes;
    }

    @Override
    public int compareTo(WeeklyEntry o) {
        return this.weekday.compareTo(o.getWeekday());
    }
}
