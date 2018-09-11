package PBExam_Evening;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int juniors = Integer.parseInt(console.nextLine());
        int seniors = Integer.parseInt(console.nextLine());
        String raceType = console.nextLine();
        double juniorsTax = 0;
        double seniorsTax = 0;
        double sum = 0;
        double expenses = 0;

        switch (raceType) {
            case "trail":
                juniorsTax = 5.50;
                seniorsTax = 7;
                break;
            case "cross-country":
                juniorsTax = 8;
                seniorsTax = 9.50;
                if (juniors + seniors >= 50) {
                    juniorsTax = 8 - (8 * 0.25);
                    seniorsTax = 9.50 - (9.50 * 0.25);
                }
                break;
            case "downhill":
                juniorsTax = 12.25;
                seniorsTax = 13.75;
                break;
            case "road":
                juniorsTax = 20;
                seniorsTax = 21.50;
                break;
        }

        sum = (juniorsTax * juniors) + (seniorsTax * seniors);
        expenses = sum * 0.05;
        sum = sum - expenses;

        System.out.printf("%.2f", sum);

    }
}
