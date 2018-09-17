package c_Inheritance_Exercises.p03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 11) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateSalaryPerHour() {
        return (this.weekSalary / 7) / this.workHoursPerDay;
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Week Salary: ").append(String.format("%.2f", this.weekSalary)).append("\n");
        sb.append("Hours per day: ").append(String.format("%.2f", this.workHoursPerDay)).append("\n");
        sb.append("Salary per hour: ").append(String.format("%.2f", this.calculateSalaryPerHour())).append("\n");
        return sb.toString();
    }
}
