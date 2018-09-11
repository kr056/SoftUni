package PBExam19March2017Morning;

import java.util.Scanner;

public class TrainersSalary {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int lectures = Integer.parseInt(console.nextLine());
        double budget = Double.parseDouble(console.nextLine());
        double salaryPerLecture = budget / lectures;

        int roli = 0;
        int trofon = 0;
        int sino = 0;
        int jelev = 0;
        int royal = 0;
        int others = 0;

        for (int i = 0; i < lectures; i++) {
            String lectorName = console.nextLine();
            if (lectorName.equals("Roli")) {
                roli++;
            } else if (lectorName.equals("Trofon")) {
                trofon++;
            } else if (lectorName.equals("RoYaL")) {
                royal++;
            } else if (lectorName.equals("Sino")) {
                sino++;
            } else if (lectorName.equals("Jelev")) {
                jelev++;
            } else {
                others++;
            }
        }

        System.out.printf("Jelev salary: %.2f lv%n", salaryPerLecture * jelev);
        System.out.printf("RoYaL salary: %.2f lv%n", salaryPerLecture * royal);
        System.out.printf("Roli salary: %.2f lv%n", salaryPerLecture * roli);
        System.out.printf("Trofon salary: %.2f lv%n", salaryPerLecture * trofon);
        System.out.printf("Sino salary: %.2f lv%n", salaryPerLecture * sino);
        System.out.printf("Others salary: %.2f lv", salaryPerLecture * others);

    }
}
