package PBExam_18March2017;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double budget = Double.parseDouble(console.nextLine());
        String season = console.nextLine();

        double price = 0;

        if (budget >= 10 && budget <= 100) {
            if (season.equals("Summer")) {
                price = budget * 35 / 100;
                System.out.printf("Economy class%n");
                System.out.printf("Cabrio - %.2f", price);
            } else if (season.equals("Winter")) {
                price = budget * 65 / 100;
                System.out.printf("Economy class%n");
                System.out.printf("Jeep - %.2f", price);
            }
        } else if (budget > 100 && budget <= 500) {
            if (season.equals("Summer")) {
                price = budget * 0.45;
                System.out.printf("Compact class%n");
                System.out.printf("Cabrio - %.2f", price);
            } else if (season.equals("Winter")) {
                price = budget * 0.80;
                System.out.printf("Compact class%n");
                System.out.printf("Jeep - %.2f", price);
            }
        } else if (budget > 500) {
            price = budget * 0.90;
            System.out.printf("Luxury class%n");
            System.out.printf("Jeep - %.2f", price);
        }

    }
}
