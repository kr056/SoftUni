package PBExam19March2017Morning;


import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double budget = Double.parseDouble(console.nextLine());
        String season = console.nextLine();

        double price = 0;

        if (budget >= 10 && budget <= 1000) {
            if (season.equals("Summer")) {
                price = budget * 65 / 100;
                System.out.printf("Alaska - Camp - ");
                System.out.printf("%.2f", price);
            } else if (season.equals("Winter")) {
                price = budget * 45 / 100;
                System.out.printf("Morocco - Camp - ");
                System.out.printf("%.2f", price);
            }
        } else if (budget > 1000 && budget <= 3000) {
            if (season.equals("Summer")) {
                price = budget * 0.80;
                System.out.printf("Alaska - Hut - ");
                System.out.printf("%.2f", price);
            } else if (season.equals("Winter")) {
                price = budget * 0.60;
                System.out.printf("Morocco - Hut - ");
                System.out.printf("%.2f", price);
            }
        } else if (budget > 3000) {
            price = budget * 0.90;
            if (season.equals("Summer")) {
                System.out.printf("Alaska - Hotel - ");
                System.out.printf("%.2f", price);
            } else if (season.equals("Winter")) {
                System.out.printf("Morocco - Hotel - ");
                System.out.printf("%.2f", price);
            }

        }

    }
}
