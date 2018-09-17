package NeedForSpeed;

import NeedForSpeed.Cars.Car;
import NeedForSpeed.Cars.PerformanceCar;
import NeedForSpeed.Cars.ShowCar;
import NeedForSpeed.Races.*;

public class Factory {

    public static Car createCar(String type, String brand, String model,
                                int yearOfProduction, int horsepower, int acceleration,
                                int suspension, int durability) {
        switch (type) {
            case "Performance":
                return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            case "Show":
                return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            default:
                return null;
        }
    }

    public static Race createRace(String type, int length, String route, int prizePool) {
        switch (type) {
            case "Casual":
                return new CasualRace(length, route, prizePool);
            case "Drag":
                return new DragRace(length, route, prizePool);
            case "Drift":
                return new DriftRace(length, route, prizePool);
            default:
                return null;
        }
    }

    public static Race createRace(String type, int length, String route, int prizePool, int fourthParam) {
        switch (type) {
            case "TimeLimit":
                return new TimeLimitRace(length, route, prizePool, fourthParam);
            case "Circuit":
                return new CircuitRace(length, route, prizePool, fourthParam);
            default:
                return null;
        }
    }
}
