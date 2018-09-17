package PolymorphismExercises.p01_Vehichles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    protected void increaseFuel(double refuelLiters) {
        double updatedFuel = (refuelLiters * 0.95) + super.getFuelQuantity();

        if (updatedFuel > super.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            super.setFuelQuantity(updatedFuel);
        }
    }


    @Override
    protected void driveVehicle(double travelledKm) {
        double totalSpentFuel = (super.getFuelConsumptionInLitersPerKm() * travelledKm) + (travelledKm * 1.6);

        if (totalSpentFuel > super.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
        } else {
            double decreaseFuel = super.getFuelQuantity() - totalSpentFuel;
            super.setFuelQuantity(decreaseFuel);

            System.out.println("Truck travelled " + super.df.format(travelledKm) + " km");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Truck: ").append(String.format("%.2f", super.getFuelQuantity())).append("\n");

        return sb.toString();
    }
}
