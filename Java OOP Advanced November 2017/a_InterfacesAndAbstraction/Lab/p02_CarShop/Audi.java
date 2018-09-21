package a_InterfacesAndAbstraction.Lab.p02_CarShop;

public class Audi implements Rentable {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private Integer minDaysForRent;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced
            , Integer minDaysForRent, Double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minDaysForRent = minDaysForRent;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires%n",
                this.model, this.countryProduced, Car.TIRES);
    }

    @Override
    public Integer getMinRentDay() {
        return this.minDaysForRent;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
}
