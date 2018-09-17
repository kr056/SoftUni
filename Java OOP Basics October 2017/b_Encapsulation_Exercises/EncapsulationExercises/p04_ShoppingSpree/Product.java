package EncapsulationExercises.p04_ShoppingSpree;

public class Product {
    private String name;
    private double price;

    double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price = price;
    }
}
