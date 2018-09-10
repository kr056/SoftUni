import java.util.Scanner;

public class p13_AreaOfFigures {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String figure = console.nextLine();

        if (figure.equals("square")) {
            double a = Double.parseDouble(console.nextLine());
            a = a * a;
            System.out.printf("%.3f", a);
        } else if (figure.equals("triangle")) {
            double a = Double.parseDouble(console.nextLine());
            double h = Double.parseDouble(console.nextLine());
            double face = a * h / 2;
            System.out.printf("%.3f", face);
        } else if (figure.equals("circle")) {
            double r = Double.parseDouble(console.nextLine());

            double face = Math.PI * r * r;
            System.out.printf("%.3f", face);
        } else  if(figure.equals("rectangle")) {
            double a = Double.parseDouble(console.nextLine());
            double b = Double.parseDouble(console.nextLine());

            double face = a * b;
            System.out.printf("%.3f", face);
        }

    }
}
