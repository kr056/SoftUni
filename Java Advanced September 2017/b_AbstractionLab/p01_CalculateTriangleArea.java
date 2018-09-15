package b_AbstractionLab;

import java.util.Scanner;

public class p01_CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        scanner.nextLine();

        double area = CalcTriangleArea(base, height);

        System.out.printf("Area = %.2f", area);
    }

    private static double CalcTriangleArea(double base, double height) {
        return (base * height) / 2;
    }
}
