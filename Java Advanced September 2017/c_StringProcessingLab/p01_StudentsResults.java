package c_StringProcessingLab;

import java.util.Scanner;

public class p01_StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] student = scanner.nextLine().split("[\\s+|,|-]+");
        String name = student[0];
        double grade1 = Double.parseDouble(student[1]);
        double grade2 = Double.parseDouble(student[2]);
        double grade3 = Double.parseDouble(student[3]);
        double average = (grade1 + grade2 + grade3) / 3;

        String header = String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$s|"
                , "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");

        System.out.println(header);

        String studentDetails = String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|"
                , name, grade1, grade2, grade3, average);

        System.out.println(studentDetails);
    }
}
