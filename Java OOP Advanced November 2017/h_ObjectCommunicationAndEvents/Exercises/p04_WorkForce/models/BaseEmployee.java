package h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.models;

import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.interfaces.Employee;

public class BaseEmployee implements Employee {
    private String name;
    private int workHoursPerWeek;

    public BaseEmployee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHoursPerDay() {
        return this.workHoursPerWeek;
    }
}
