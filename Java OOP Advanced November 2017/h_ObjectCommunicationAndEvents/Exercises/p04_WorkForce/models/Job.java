package h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.models;

import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.interfaces.Employee;

public class Job {
    private String name;
    private int hoursWorkPerDayRequired;
    private Employee employee;

    public Job(String name, int hoursWorkPerDayRequired, Employee employee) {
        this.name = name;
        this.hoursWorkPerDayRequired = hoursWorkPerDayRequired;
        this.employee = employee;
    }

    public boolean update() {
        this.hoursWorkPerDayRequired -= this.employee.getWorkHoursPerDay();

        if (this.hoursWorkPerDayRequired <= 0) {
            System.out.println("Job " + this.name + " done!");
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Job: " + this.name + " Hours Remaining: " + this.hoursWorkPerDayRequired;
    }

}
