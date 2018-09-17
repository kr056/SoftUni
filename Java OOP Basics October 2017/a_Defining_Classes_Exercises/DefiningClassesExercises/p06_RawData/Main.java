package DefiningClassesExercises.p06_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int carsCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < carsCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.valueOf(tokens[1]);
            int enginePower = Integer.valueOf(tokens[2]);
            int cargoWeight = Integer.valueOf(tokens[3]);

            String cargoType = tokens[4];
            double tireOnePressure = Double.valueOf(tokens[5]);
            int tireOneAge = Integer.valueOf(tokens[6]);
            double tireTwoPressure = Double.valueOf(tokens[7]);

            int tireTwoAge = Integer.valueOf(tokens[8]);
            double tireThreePressure = Double.valueOf(tokens[9]);
            int tireThreeAge = Integer.valueOf(tokens[10]);

            double tireFourPressure = Double.valueOf(tokens[11]);
            int tireFourAge = Integer.valueOf(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tireOne = new Tire(tireOnePressure, tireOneAge);
            Tire tireTwo = new Tire(tireTwoPressure, tireTwoAge);
            Tire tireThree = new Tire(tireThreePressure, tireThreeAge);
            Tire tireFour = new Tire(tireFourPressure, tireFourAge);

            Tire[] tires = new Tire[4];
            tires[0] = tireOne;
            tires[1] = tireTwo;
            tires[2] = tireThree;
            tires[3] = tireFour;

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }
        String wantedType = bf.readLine();

        switch (wantedType) {
            case "fragile":
                cars.stream()
                        .filter(x -> x.getCargo().getType().equals("fragile"))
                        .filter(Car::checkTiresPressure)
                        .forEach(s -> System.out.println(s.getModel()));
                break;
            case "flamable":
                cars.stream()
                        .filter(x -> x.getCargo().getType().equals("flamable"))
                        .filter(y -> y.getEngine().getPower() > 250)
                        .forEach(s -> System.out.println(s.getModel()));
                break;
        }
    }

}
