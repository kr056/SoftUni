package PolymorphismExercises.p01_Vehichles;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
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

    protected void driveBus(double travelledKm, String busCmd) {
        double totalSpentFuel = 0;

        if (busCmd.toLowerCase().equals("drive")) {
            totalSpentFuel = super.getFuelConsumptionInLitersPerKm() * travelledKm + (travelledKm * 1.4);
        } else {
            totalSpentFuel = super.getFuelConsumptionInLitersPerKm() * travelledKm;
        }

        if (totalSpentFuel > super.getFuelQuantity()) {
            System.out.println("Bus needs refueling");
        } else {
            double decreaseFuel = super.getFuelQuantity() - totalSpentFuel;
            super.setFuelQuantity(decreaseFuel);

            System.out.println("Bus travelled " + super.df.format(travelledKm) + " km");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bus: ").append(String.format("%.2f", super.getFuelQuantity())).append("\n");

        return sb.toString();
    }
}
