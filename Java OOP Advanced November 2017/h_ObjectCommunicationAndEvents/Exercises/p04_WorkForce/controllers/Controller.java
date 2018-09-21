package h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.controllers;

import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.interfaces.Employee;
import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.models.Job;
import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.models.PartTimeEmployee;
import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.models.StandartEmployee;

import java.util.*;

public class Controller {
    private List<Job> jobs;
    private Map<String, Employee> employees;

    public Controller() {
        this.jobs = new ArrayList<>();
        this.employees = new LinkedHashMap<>();
    }

    public void addStandartEmployee(List<String> arguments) {
        Employee employee = new StandartEmployee(arguments.get(1));
        this.employees.put(arguments.get(1), employee);
    }

    public void addPartimeEmployee(List<String> arguments) {
        Employee employee = new PartTimeEmployee(arguments.get(1));
        this.employees.put(arguments.get(1), employee);
    }

    public void addJob(List<String> arguments) {
        Job job = new Job(arguments.get(1), Integer.valueOf(arguments.get(2)), this.employees.get(arguments.get(3)));
        this.jobs.add(job);
    }

    public void passWeek() {
        List<Job> copyJobs = new ArrayList<>(this.jobs);
        for (Job job : copyJobs) {
            if (job.update()) {
                this.jobs.remove(job);
            }
        }
    }

    public void status() {
        for (Job job : this.jobs) {
            System.out.println(job.toString());
        }
    }
}
