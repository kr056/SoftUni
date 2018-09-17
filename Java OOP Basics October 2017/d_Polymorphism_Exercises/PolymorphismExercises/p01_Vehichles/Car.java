package PolymorphismExercises.p01_Vehichles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    protected void increaseFuel(double refuelLiters) {
        double totalFuel = refuelLiters + super.getFuelQuantity();

        if (totalFuel > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            super.setFuelQuantity(totalFuel);
        }
    }

    @Override
    protected void driveVehicle(double travelledKm) {
        double totalSpentFuel = super.getFuelConsumptionInLitersPerKm() * travelledKm + (travelledKm * 0.9);

        if (totalSpentFuel > super.getFuelQuantity()) {
            System.out.println("Car needs refueling");
        } else {
            double decreaseFuel = super.getFuelQuantity() - totalSpentFuel;
            super.setFuelQuantity(decreaseFuel);

            System.out.println("Car travelled " + super.df.format(travelledKm) + " km");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: ").append(String.format("%.2f", super.getFuelQuantity())).append("\n");

        return sb.toString();
    }
}
