import java.util.Scanner;

public class p08_TradeComissions {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String town = console.nextLine();
        double sales = Double.parseDouble(console.nextLine());

        double result = 0;

        if (sales < 0) {
            System.out.println("error");
        }

        if (town.equals("Sofia")) {
            if (sales >= 0 && sales <= 500) {
                result = sales * 0.05;
            } else if (sales > 500 && sales <= 1000) {
                result = sales * 0.07;
            } else if (sales > 1000 && sales <= 10000) {
                result = sales * 0.08;
            } else if (sales > 10000) {
                result = sales * 0.12;
            }
        } else if (town.equals("Varna")) {
            if (sales >= 0 && sales <= 500) {
                result = sales * 0.045;
            } else if (sales > 500 && sales <= 1000) {
                result = sales * 0.075;
            } else if (sales > 1000 && sales <= 10000) {
                result = sales * 0.1;
            } else if (sales > 10000) {
                result = sales * 0.13;
            }
        } else if (town.equals("Plovdiv")) {
            if (sales >= 0 && sales <= 500) {
                result = sales * 0.055;
            } else if (sales > 500 && sales <= 1000) {
                result = sales * 0.08;
            } else if (sales > 1000 && sales <= 10000) {
                result = sales * 0.12;
            } else if (sales > 10000) {
                result = sales * 0.145;
            }
        } else {
            System.out.println("error");
        }
        System.out.printf("%.2f", result);

    }
}
