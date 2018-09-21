package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs;

public class Repair implements IRepair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Part Name: %s Hours Worked: %d%n",
                this.getPartName(), this.getHoursWorked()));

        return sb.toString();
    }
}
