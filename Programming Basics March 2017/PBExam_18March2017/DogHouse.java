package PBExam_18March2017;

import java.util.Scanner;

public class DogHouse {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double length = Double.parseDouble(console.nextLine());
        double height = Double.parseDouble(console.nextLine());

        double side = length * (length / 2);
        double backSide = (length / 2 * length / 2) + ((length / 2 * (height - length / 2) / 2));
        double frontSide = (length / 2 * length / 2) + ((length / 2 * (height - length / 2) / 2)) - (length / 5 * length / 5);
        double roof = length * (length / 2) * 2;

        double greenPaint = ((side * 2) + backSide + frontSide) / 3;
        double redPaint = roof / 5;

        System.out.printf("%.2f%n%.2f", greenPaint, redPaint);

    }
}
