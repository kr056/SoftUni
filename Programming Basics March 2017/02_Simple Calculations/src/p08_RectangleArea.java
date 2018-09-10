import java.util.Scanner;

public class p08_RectangleArea {
    public static void main(String[] args){

        Scanner console = new Scanner(System.in);

        double a = Double.parseDouble(console.nextLine());
        double h = Double.parseDouble(console.nextLine());

        double area = a * h / 2;

        System.out.printf("Area=%.2f",area);

    }
}
