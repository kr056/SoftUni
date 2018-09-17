package PolymorphismExercises.p01_Vehichles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = bf.readLine().split("\\s+");
        String[] truckInfo = bf.readLine().split("\\s+");
        String[] busInfo = bf.readLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int numberOfCommands = Integer.valueOf(bf.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] cmd = bf.readLine().split("\\s+");

            switch (cmd[1].toLowerCase()) {
                case "car":
                    if (cmd[0].toLowerCase().equals("drive")) {
                        car.driveVehicle(Double.parseDouble(cmd[2]));
                    } else {
                        if (Double.parseDouble(cmd[2]) <= 0.0) {
                            System.out.println("Fuel must be a positive number");
                            break;
                        }
                        car.increaseFuel(Double.parseDouble(cmd[2]));
                    }
                    break;
                case "truck":
                    if (cmd[0].toLowerCase().equals("drive")) {
                        truck.driveVehicle(Double.parseDouble(cmd[2]));
                    } else {
                        if (Double.parseDouble(cmd[2]) <= 0.0) {
                            System.out.println("Fuel must be a positive number");
                            break;
                        }
                        truck.increaseFuel(Double.parseDouble(cmd[2]));
                    }
                    break;
                case "bus":
                    if (cmd[0].toLowerCase().equals("refuel")) {
                        bus.increaseFuel(Double.parseDouble(cmd[2]));
                    } else {
                        if (Double.parseDouble(cmd[2]) <= 0.0) {
                            System.out.println("Fuel must be a positive number");
                            break;
                        }
                        bus.driveBus(Double.parseDouble(cmd[2]), cmd[0]);
                    }
                    break;
            }
        }

        System.out.print(car.toString());
        System.out.print(truck.toString());
        System.out.print(bus.toString());
    }
}
