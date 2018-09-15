package a_IntroToJavaLab;

import java.util.Scanner;

public class p10_ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int position = scanner.nextInt();
        int val = scanner.nextInt();

        if (val == 0) {

            int mask = ~(1 << position);
            int result = num & mask;

            System.out.println(result);
        } else {

            int mask = 1 << position;
            int result = num | mask;

            System.out.println(result);
        }
    }
}
