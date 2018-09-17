package DefiningClassesExercises.p05_SpeedRacing;

class Car {
    private String model;
    private double fuel;
    private double fuelCostForOneKm;
    private int distanceTraveled = 0;

    void driveCar(int amountOfKmToTravel) {
        double neededFuelForTravel = amountOfKmToTravel * this.fuelCostForOneKm;

        if (neededFuelForTravel <= this.fuel) {
            this.fuel -= neededFuelForTravel;
            this.distanceTraveled += amountOfKmToTravel;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    Car(String model, double fuel, double fuelCostForOneKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostForOneKm = fuelCostForOneKm;
    }

    String getModel() {
        return model;
    }

    double getFuel() {
        return fuel;
    }

    int getDistanceTraveled() {
        return distanceTraveled;
    }
}
