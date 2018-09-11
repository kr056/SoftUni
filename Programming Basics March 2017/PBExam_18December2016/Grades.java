package PBExam_18December2016;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int studentsCount = Integer.parseInt(console.nextLine());

        double fail = 0;
        double top = 0;
        double mid = 0;
        double good = 0;
        double average = 0;

        for (int i = 0; i < studentsCount; i++) {

            double eachstudentGrade = Double.parseDouble(console.nextLine());
            average += eachstudentGrade;
            if (eachstudentGrade >= 5.00) {
                top++;
            } else if (eachstudentGrade >= 4.00 && eachstudentGrade <= 4.99) {
                good++;
            } else if (eachstudentGrade >= 3.00 && eachstudentGrade <= 3.99) {
                mid++;
            } else if (eachstudentGrade < 3.00) {
                fail++;
            }

        }

        top = (top / studentsCount) * 100;
        good = (good / studentsCount) * 100;
        mid = (mid / studentsCount) * 100;
        fail = (fail / studentsCount) * 100;
        average = average / studentsCount;

        System.out.printf("Top students: %.2f%%%n", top);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", good);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", mid);
        System.out.printf("Fail: %.2f%%%n", fail);
        System.out.printf("Average: %.2f", average);

    }
}
