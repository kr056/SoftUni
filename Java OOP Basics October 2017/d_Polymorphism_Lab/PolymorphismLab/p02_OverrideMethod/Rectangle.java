package PolymorphismLab.p02_OverrideMethod;


public class Rectangle {
    private double sideA;
    private double sideB;

     Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return this.sideA * this.sideB;
    }
}
