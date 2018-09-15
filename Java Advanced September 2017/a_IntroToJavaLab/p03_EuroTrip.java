package a_IntroToJavaLab;

import java.math.BigDecimal;
import java.util.Scanner;

public class p03_EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wurstKg = Double.parseDouble(scanner.nextLine());
        double pricePerKg = 1.2;
        BigDecimal priceInBGN = new BigDecimal(wurstKg * pricePerKg);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInMarks = priceInBGN.multiply(exchangeRate);

        System.out.printf("%.2f marks", priceInMarks);
    }
}
