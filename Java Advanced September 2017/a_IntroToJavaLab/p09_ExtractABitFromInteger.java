package a_IntroToJavaLab;

import java.util.Scanner;

public class p09_ExtractABitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int index = scanner.nextInt();

        int mask = num >> index;
        int bit = mask & 1;

        System.out.println(bit);
    }
}
