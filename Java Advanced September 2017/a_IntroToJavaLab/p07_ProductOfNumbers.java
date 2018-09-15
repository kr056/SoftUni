package a_IntroToJavaLab;

import java.math.BigInteger;
import java.util.Scanner;

public class p07_ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger factorial = new BigInteger(String.valueOf(n));

        for (int i = m; i > n; i--) {
            BigInteger operand = BigInteger.valueOf(i);
            factorial = factorial.multiply(operand);
        }

        System.out.printf("product[%d..%d] = %d", n, m, factorial);
    }
}
