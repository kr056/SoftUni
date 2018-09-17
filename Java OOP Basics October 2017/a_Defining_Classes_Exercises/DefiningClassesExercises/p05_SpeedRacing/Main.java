package DefiningClassesExercises.p05_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> garage = new LinkedHashMap<>();

        int carsCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < carsCount; i++) {
            String[] line = bf.readLine().split("\\s+");

            String model = line[0];
            double fuel = Double.valueOf(line[1]);
            double fuelCostForOneKm = Double.valueOf(line[2]);

            Car car = new Car(model, fuel, fuelCostForOneKm);
            garage.put(car.getModel(), car);
        }

        while (true) {
            String input = bf.readLine();

            if ("End".equals(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            int amountOfKm = Integer.valueOf(tokens[2]);

            garage.get(model).driveCar(amountOfKm);

        }

        for (String model : garage.keySet()) {
            System.out.printf("%s %.2f %d%n", model, garage.get(model).getFuel(),
                    garage.get(model).getDistanceTraveled());
        }

    }
}
