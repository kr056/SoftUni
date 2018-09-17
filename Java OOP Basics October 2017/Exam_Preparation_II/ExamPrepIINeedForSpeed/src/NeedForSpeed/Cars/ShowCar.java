package NeedForSpeed.Cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {
        StringBuilder carRep = new StringBuilder();
        carRep.append(String.format("%s %s %d%n", super.getBrand(), super.getModel()
                , super.getYearOfProduction()));
        carRep.append(String.format("%d HP, 100 m/h in %d s%n", super.getHorsepower()
                , super.getAcceleration()));
        carRep.append(String.format("%d Suspension force, %d Durability%n", super.getSuspension(),
                super.getDurability()));
        carRep.append(String.format("%d *%n", this.stars));

        return carRep.toString();
    }

    @Override
    public void tuneCar(int tuneIndex, String addOn) {
        super.tuneCar(tuneIndex, addOn);
        this.stars += tuneIndex;
    }
}
