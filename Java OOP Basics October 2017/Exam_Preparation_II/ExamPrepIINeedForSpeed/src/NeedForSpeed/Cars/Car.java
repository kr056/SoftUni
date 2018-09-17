package NeedForSpeed.Cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }


    public abstract String toString();

    public void tuneCar(int tuneIndex, String addOn) {
        this.horsepower += tuneIndex;
        this.suspension += tuneIndex / 2;
    }

    public int getOP() {
        return (this.horsepower / this.acceleration) + (this.suspension + this.durability);
    }

    public int getEP() {
        return this.horsepower / this.acceleration;
    }

    public int getSP() {
        return this.suspension + this.durability;
    }

    public int getTP() {
        return (this.horsepower / 100) * this.acceleration;
    }

    public void decreaseDurability(int quantity) {
        this.durability -= quantity;
    }

}
