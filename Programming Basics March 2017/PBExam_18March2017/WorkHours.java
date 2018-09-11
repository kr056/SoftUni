package PBExam_18March2017;

import java.util.Scanner;

public class WorkHours {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(console.nextLine());
        int workers = Integer.parseInt(console.nextLine());
        int workDays = Integer.parseInt(console.nextLine());

        int hoursWorked;
        hoursWorked = workers * workDays * 8;

        if (hoursWorked >= hoursNeeded) {
            System.out.printf("%d hours left", (hoursWorked - hoursNeeded));
        } else if (hoursWorked < hoursNeeded) {
            int penalties = (hoursNeeded - hoursWorked) * workDays;
            System.out.printf("%d overtime%n", hoursNeeded - hoursWorked);
            System.out.printf("Penalties: %d", penalties);
        }

    }
}
