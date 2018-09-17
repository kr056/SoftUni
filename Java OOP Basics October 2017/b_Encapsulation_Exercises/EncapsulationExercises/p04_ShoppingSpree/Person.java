package EncapsulationExercises.p04_ShoppingSpree;

import java.util.*;

public class Person {
    private String name;
    private double money;
    private List<Product> products;
    private List<String> bag;

    public void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
        this.bag = new ArrayList<>();
    }

    void addProduct(Product product) {
        if (this.money < product.getPrice()) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        } else {
            System.out.printf("%s bought %s%n", this.name, product.getName());
            this.products.add(product);
            this.bag.add(product.getName());
            updatePersonMoney(product);
        }
    }

    private void updatePersonMoney(Product product) {
        this.money -= product.getPrice();
    }

    void printPersonProductBag() {
        if (this.products.size() == 0) {
            System.out.printf("%s - Nothing bought%n", this.name);
        } else {
            System.out.printf("%s - %s%n", this.name, Arrays.toString(this.bag.toArray()).replaceAll("[]\\[]", ""));
        }
    }
}
