package PBExam_18December2016;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(console.nextLine());
        int roses = Integer.parseInt(console.nextLine());
        int tulips = Integer.parseInt(console.nextLine());
        String season = console.nextLine();
        String holiday = console.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;
        int all = chrysanthemums + roses + tulips;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = 2;
                rosesPrice = 4.1;
                tulipsPrice = 2.5;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = 3.75;
                rosesPrice = 4.5;
                tulipsPrice = 4.15;
                break;
        }

        double sum = (chrysanthemumsPrice * chrysanthemums) + (roses * rosesPrice) + (tulips * tulipsPrice);

        if (holiday.equals("Y")) {
            sum = sum * 1.15;
            if (tulips > 7 && season.equals("Spring")) {
                sum = sum - (sum * 0.05);
            }
            if (roses >= 10 && season.equals("Winter")) {
                sum = sum - (sum * 0.10);
            }
            if (all > 20) {
                sum = sum - (sum * 0.20);
            }
        } else if (holiday.equals("N")) {
            if (tulips > 7 && season.equals("Spring")) {
                sum = sum - (sum * 0.05);
            }
            if (roses >= 10 && season.equals("Winter")) {
                sum = sum - (sum * 0.10);
            }
            if (all > 20) {
                sum = sum - (sum * 0.20);
            }
        }

        System.out.printf("%.2f", sum + 2);
    }
}
