package PolymorphismLab.p03_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    double calculatePerimeter() {
        return (Math.PI * 2 * this.radius);
    }

    @Override
    double calculateArea() {
        return (Math.PI * this.radius * this.radius);
    }
}
