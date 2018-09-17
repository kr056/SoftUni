package c_Inheritance_Exercises.p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] studentProps = bf.readLine().split("\\s+");
        String[] workerProps = bf.readLine().split("\\s+");

        String studentFirstName = studentProps[0];
        String studentLastName = studentProps[1];
        String facultyNumber = studentProps[2];

        String workerFirstName = workerProps[0];
        String workerLastName = workerProps[1];
        double weekSalary = Double.valueOf(workerProps[2]);
        double workingHoursPerDay = Double.valueOf(workerProps[3]);

        try {
            Student student = new Student(studentFirstName, studentLastName, facultyNumber);
            Worker worker = new Worker(workerFirstName, workerLastName, weekSalary, workingHoursPerDay);
            System.out.println(student.toString());
            System.out.println(worker.toString());

        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

    }
}
