package PBExam19March2017Evening;

import java.util.Scanner;

public class Styrofoam {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double budget = Double.parseDouble(console.nextLine());
        double houseArea = Double.parseDouble(console.nextLine());
        int windowsCount = Integer.parseInt(console.nextLine());
        double metersInPackage = Double.parseDouble(console.nextLine());
        double pricePackage = Double.parseDouble(console.nextLine());

        double styrofoam = houseArea - (windowsCount * 2.4);
        styrofoam = styrofoam * 1.10;
        double packages = Math.ceil(styrofoam / metersInPackage);
        double price = packages * pricePackage;

        if (budget >= price) {
            System.out.printf("Spent: %.2f%n", (price));
            System.out.printf("Left: %.2f", (budget - price));
        } else if (price > budget) {
            System.out.printf("Need more: %.2f", (price - budget));
        }

    }
}
