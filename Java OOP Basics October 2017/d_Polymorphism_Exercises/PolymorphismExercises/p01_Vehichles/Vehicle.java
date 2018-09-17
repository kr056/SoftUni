package PolymorphismExercises.p01_Vehichles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;
    private double tankCapacity;

    DecimalFormat df = new DecimalFormat("#.##");

    public Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    double getFuelQuantity() {
        return fuelQuantity;
    }

    double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    protected void increaseFuel(double refuelLiters) {
    }

    protected void driveVehicle(double travelledKm) {

    }

}
