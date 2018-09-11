package PBExam_18March2017;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int turns = Integer.parseInt(console.nextLine());

        double points = 0;

        double zeroToNine = 0;
        double tenToNineteen = 0;
        double twentyToTwentynine = 0;
        double thirtyToThirtynine = 0;
        double fourtyToFifty = 0;
        double invalidNumber = 0;

        for (int i = 0; i < turns; i++) {
            int number = Integer.parseInt(console.nextLine());

            if (number >= 0 && number <= 9) {
                points += (number * 0.20);
                zeroToNine++;
            } else if (number > 9 && number < 20) {
                points += (number * 0.30);
                tenToNineteen++;
            } else if (number >= 20 && number < 30) {
                points += (number * 0.40);
                twentyToTwentynine++;
            } else if (number >= 30 && number < 40) {
                points += 50;
                thirtyToThirtynine++;
            } else if (number >= 40 && number <= 50) {
                points += 100;
                fourtyToFifty++;
            } else {
                points = points / 2;
                invalidNumber++;
            }

        }
        zeroToNine = (zeroToNine / turns) * 100;
        tenToNineteen = (tenToNineteen / turns) * 100;
        twentyToTwentynine = (twentyToTwentynine / turns) * 100;
        thirtyToThirtynine = (thirtyToThirtynine / turns) * 100;
        fourtyToFifty = (fourtyToFifty / turns) * 100;
        invalidNumber = (invalidNumber / turns) * 100;


        System.out.printf("%.2f%n", points);
        System.out.printf("From 0 to 9: %.2f%%%n", zeroToNine);
        System.out.printf("From 10 to 19: %.2f%%%n", tenToNineteen);
        System.out.printf("From 20 to 29: %.2f%%%n", twentyToTwentynine);
        System.out.printf("From 30 to 39: %.2f%%%n", thirtyToThirtynine);
        System.out.printf("From 40 to 50: %.2f%%%n", fourtyToFifty);
        System.out.printf("Invalid numbers: %.2f%%", invalidNumber);

    }
}
