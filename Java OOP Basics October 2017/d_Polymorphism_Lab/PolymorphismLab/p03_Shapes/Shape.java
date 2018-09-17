package PolymorphismLab.p03_Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    double calculatePerimeter() {
        return 0;
    }

    double calculateArea() {
        return 0;
    }

}
