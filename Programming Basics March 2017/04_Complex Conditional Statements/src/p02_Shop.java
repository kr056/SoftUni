import java.util.Scanner;

public class p02_Shop {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String product = console.nextLine();
        String city = console.nextLine();
        double quantity = Double.parseDouble(console.nextLine());

        double price = 0;

        if (city.equalsIgnoreCase("Plovdiv")) {
            if (product.equalsIgnoreCase("coffee")) {
                price = quantity * 0.4;
            } else if (product.equalsIgnoreCase("water")) {
                price = quantity * 0.7;
            } else if (product.equalsIgnoreCase("beer")) {
                price = quantity * 1.15;
            } else if (product.equalsIgnoreCase("sweets")) {
                price = quantity * 1.30;
            } else if (product.equalsIgnoreCase("peanuts")) {
                price = quantity * 1.50;
            }
        } else if (city.equalsIgnoreCase("Varna")) {
            if (product.equalsIgnoreCase("coffee")) {
                price = quantity * 0.45;
            } else if (product.equalsIgnoreCase("water")) {
                price = quantity * 0.7;
            } else if (product.equalsIgnoreCase("beer")) {
                price = quantity * 1.1;
            } else if (product.equalsIgnoreCase("sweets")) {
                price = quantity * 1.35;
            } else if (product.equalsIgnoreCase("peanuts")) {
                price = quantity * 1.55;
            }
        } else if (city.equalsIgnoreCase("Sofia")) {
            if (product.equalsIgnoreCase("coffee")) {
                price = quantity * 0.5;
            } else if (product.equalsIgnoreCase("water")) {
                price = quantity * 0.8;
            } else if (product.equalsIgnoreCase("beer")) {
                price = quantity * 1.2;
            } else if (product.equalsIgnoreCase("sweets")) {
                price = quantity * 1.45;
            } else if (product.equalsIgnoreCase("peanuts")) {
                price = quantity * 1.6;
            }
        }

        System.out.println(price);
    }
}
