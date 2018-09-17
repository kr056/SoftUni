package PolymorphismLab.p03_Shapes;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(3);

        System.out.printf("Circle perimeter: %.2f\n", circle.calculatePerimeter());
        System.out.printf("Circle area: %.2f\n", circle.calculateArea());

        Rectangle rectangle = new Rectangle(5, 7);

        System.out.printf("Rectangle perimeter: %.2f\n", rectangle.calculatePerimeter());
        System.out.printf("Rectangle area: %.2f\n", rectangle.calculateArea());

    }
}
