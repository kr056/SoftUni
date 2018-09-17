package NeedForSpeed.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, (horsepower + (horsepower / 2)), acceleration, (suspension - (suspension / 4)), durability);
        this.addOns = new ArrayList<>();
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

        if (this.addOns.size() > 0) {
            carRep.append("Add-ons: ");
            carRep.append(Arrays.toString(this.addOns.toArray()).replaceAll("[]\\[]", "")).append("\n");
        } else {
            carRep.append("Add-ons: None").append("\n");
        }

        return carRep.toString();
    }

    @Override
    public void tuneCar(int tuneIndex, String addOn) {
        super.tuneCar(tuneIndex, addOn);
        this.addOns.add(addOn);
    }
}
