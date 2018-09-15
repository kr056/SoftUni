package a_IntroToJavaExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class p12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehiclesInput = scanner.nextLine().split("\\s+");

        ArrayList<String> vehicles = new ArrayList();
        for (int i = 0; i < vehiclesInput.length; i++) {
            vehicles.add(vehiclesInput[i]);
        }

        int vehiclesSold = 0;

        while (true) {
            String request = scanner.nextLine();

            if (request.equals("End of customers!")) {
                break;
            }

            String[] cmd = request.split("\\s+");
            String vehicleType = cmd[0].toLowerCase().charAt(0) + cmd[2];

            if (vehicles.contains(vehicleType)) {
                int price = vehicleType.charAt(0) * Integer.parseInt(cmd[2]);

                System.out.printf("Yes, sold for %d$\n", price);

                vehicles.remove(vehicleType);
                vehiclesSold++;
            } else {
                System.out.println("No");
            }
        }

        System.out.println("Vehicles left: " + vehicles.toString().replace("[", "")
                .replace("]", ""));

        System.out.printf("Vehicles sold: %d\n", vehiclesSold);
    }
}
