package f_FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p04_AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] prices = Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Function<Double, Double> addVAT = x -> x * 1.2;

        System.out.println("Prices with VAT:");

        for (double price : prices) {
            System.out.printf("%.2f\n", addVAT.apply(price));
        }
    }
}
