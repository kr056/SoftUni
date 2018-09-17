package NeedForSpeed;

import NeedForSpeed.Cars.Car;
import NeedForSpeed.Races.Race;

import java.util.HashMap;
import java.util.Map;

public class CarManager {

    private Map<Integer, Car> carsInfo = new HashMap<>();
    private Map<Integer, Race> racesInfo = new HashMap<>();
    private Garage garage = new Garage();


    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration,
                         int suspension, int durability) {
        this.carsInfo.putIfAbsent(id, Factory.createCar(type, brand, model, yearOfProduction, horsepower
                , acceleration, suspension, durability));
    }

    public String check(int id) {

        if (this.carsInfo.containsKey(id)) {
            return this.carsInfo.get(id).toString();
        }

        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        this.racesInfo.putIfAbsent(id, Factory.createRace(type, length, route, prizePool));
    }

    public void open(int id, String type, int length, String route, int prizePool, int goldTime) {
        this.racesInfo.putIfAbsent(id, Factory.createRace(type, length, route, prizePool, goldTime));
    }

    public void participate(int carId, int raceId) {
        if (!this.garage.getParkedCars().contains(this.carsInfo.get(carId))) {
            if (this.carsInfo.containsKey(carId) && this.racesInfo.containsKey(raceId)) {
                if (this.racesInfo.get(raceId).getClass().getSimpleName().equals("TimeLimitRace")) {
                    if (this.racesInfo.get(raceId).getParticipants().size() == 0) {
                        this.racesInfo.get(raceId).addParticipant(this.carsInfo.get(carId));
                    }
                } else {
                    this.racesInfo.get(raceId).addParticipant(this.carsInfo.get(carId));
                }
            }
        }
    }

    public String start(int id) {
        if (this.racesInfo.containsKey(id)) {
            StringBuilder resultOfRace = new StringBuilder();
            if (this.racesInfo.get(id).getParticipants().size() == 0) {
                resultOfRace.append("Cannot start the race with zero participants.").append("\n");
            } else {
                resultOfRace.append(this.racesInfo.get(id).go());
                this.racesInfo.remove(id);
            }
            return resultOfRace.toString();
        }
        return null;
    }

    public void park(int id) {
        if (this.carsInfo.containsKey(id)) {
            boolean carIsNotInRace = true;
            for (int key : this.racesInfo.keySet()) {
                if (this.racesInfo.get(key).getParticipants().contains(this.carsInfo.get(id))) {
                    carIsNotInRace = false;
                    break;
                }
            }
            if (carIsNotInRace) {
                this.garage.parkCar(this.carsInfo.get(id));
            }
        }
    }

    public void unpark(int id) {
        if (this.garage.getParkedCars().contains(this.carsInfo.get(id))) {
            this.garage.unparkCar(this.carsInfo.get(id));
        }
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.tuneCar(tuneIndex, addOn);
    }


}
