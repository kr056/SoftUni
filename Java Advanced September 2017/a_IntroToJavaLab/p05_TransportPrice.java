package a_IntroToJavaLab;

import java.util.Scanner;

public class p05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double kmToTravel = Double.parseDouble(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double taxiInitialTax = 0.70;
        double taxiDayTimeCost = 0.79;
        double taxiNightTimeCost = 0.90;

        double busCost = 0.09;
        double trainCost = 0.06;

        double totalPrice = 0;

        if (kmToTravel < 20) {

            totalPrice += taxiInitialTax;

            if (timeOfDay.equals("day")) {
                totalPrice += taxiDayTimeCost * kmToTravel;
            } else {
                totalPrice += taxiNightTimeCost * kmToTravel;
            }
        } else if (kmToTravel >= 20 && kmToTravel < 100) {
            totalPrice += busCost * kmToTravel;
        } else {
            totalPrice += trainCost * kmToTravel;
        }

        System.out.printf("%.2f", totalPrice);

    }
}
