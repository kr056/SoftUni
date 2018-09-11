package PBExam19March2017Morning;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double x = Double.parseDouble(console.nextLine());
        double y = Double.parseDouble(console.nextLine());
        double h = Double.parseDouble(console.nextLine());

        double backSide = x * x;
        double frontSide = (x * x) - (1.2 * 2);
        double rightSide = ((x * y) - (1.5 * 1.5)) * 2;
        double base = backSide + frontSide + rightSide;
        double roof = (x * y) * 2 + (x * h / 2) * 2;

        System.out.printf("%.2f%n", base / 3.4);
        System.out.printf("%.2f", roof / 4.3);

    }
}
