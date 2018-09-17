package DefiningClassesExercises.p07_CarSalesman;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int enginesCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < enginesCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            String model = tokens[0];

            int power = Integer.valueOf(tokens[1]);
            Engine engine = null;

            switch (tokens.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    try {
                        int displacement = Integer.valueOf(tokens[2]);
                        engine = new Engine(model, power, displacement);
                    } catch (NumberFormatException e) {
                        String efficiency = tokens[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    int displacement = Integer.valueOf(tokens[2]);
                    String efficiency = tokens[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }

            if (!engines.containsKey(engine.getModel())) {
                engines.put(engine.getModel(), null);
            }

            engines.put(engine.getModel(), engine);
        }

        int carsCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < carsCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            String model = tokens[0];

            String engineModel = tokens[1];
            Car car = null;

            switch (tokens.length) {
                case 2:
                    car = new Car(model, engines.get(engineModel));
                    break;
                case 3:
                    try {
                        int weight = Integer.valueOf(tokens[2]);
                        car = new Car(model, engines.get(engineModel), weight);
                    } catch (NumberFormatException e) {
                        String color = tokens[2];
                        car = new Car(model, engines.get(engineModel), color);
                    }
                    break;
                case 4:
                    int weight = Integer.valueOf(tokens[2]);
                    String color = tokens[3];
                    car = new Car(model, engines.get(engineModel), weight, color);
                    break;
            }
            cars.add(car);

        }

        for (Car car : cars) {
            car.printCarProps(car.getModel(), car.getEngine(), car.getWeight(), car.getColor());
        }

    }
}
