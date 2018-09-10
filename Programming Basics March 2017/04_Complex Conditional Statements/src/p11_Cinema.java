import java.util.Scanner;

public class p11_Cinema {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String type = console.nextLine();
        int row = Integer.parseInt(console.nextLine());
        int column = Integer.parseInt(console.nextLine());

        double price = 0;

        if (type.equals("Premiere")) {
            price = row * column * 12;
        } else if (type.equals("Normal")) {
            price = row * column * 7.5;
        } else if (type.equals("Discount")) {
            price = row * column * 5;
        }
        System.out.printf("%.2f leva", price);

    }
}
