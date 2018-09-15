package a_IntroToJavaExercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class p03_FormatingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();

        String hex = Integer.toHexString(num1).toUpperCase();
        String hexSpaces = new String(new char[10 - hex.length()])
                .replace("\0", " ");

        String binary = Integer.toBinaryString(num1);

        if (binary.length() < 11) {
            String zeroes = new String(new char[10 - binary.length()])
                    .replace("\0", "0");
            binary = zeroes + binary;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        String formattedNum2 = df.format(num2);
        String formattedNum2Spaces = new String(new char[10 - formattedNum2.length()])
                .replace("\0", " ");

        DecimalFormat df2 = new DecimalFormat("0.000");
        String formattedNum3 = df2.format(num3);
        String formattedNum3Spaces = new String(new char[10 - formattedNum3.length()])
                .replace("\0", " ");

        System.out.print("|" + hex + hexSpaces + "|" + binary + "|" + formattedNum2Spaces + formattedNum2 + "|"
                + formattedNum3 + formattedNum3Spaces + "|");

    }
}
