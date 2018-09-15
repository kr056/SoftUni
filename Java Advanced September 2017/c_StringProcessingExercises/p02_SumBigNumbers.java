package c_StringProcessingExercises;

import java.math.BigInteger;
import java.util.Scanner;

public class p02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String num1 = scan.nextLine();
        String num2 = scan.nextLine();

        System.out.println(new BigInteger(num1).add(new BigInteger(num2)));
    }
}
