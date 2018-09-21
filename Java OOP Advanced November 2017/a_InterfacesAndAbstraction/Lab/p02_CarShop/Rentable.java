package a_InterfacesAndAbstraction.Lab.p02_CarShop;

public interface Rentable extends Car {
    Integer getMinRentDay();

    Double getPricePerDay();
}
