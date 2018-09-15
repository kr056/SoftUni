package c_StringProcessingExercises;

import java.util.Scanner;


public class p08_MelrahShake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scan.nextLine());

        String pattern = scan.nextLine();

        while (true) {

            int leftIndex = sb.indexOf(pattern);
            int rightIndex = sb.lastIndexOf(pattern);

            if (leftIndex == -1 || rightIndex == -1 || "".equals(pattern)) {
                System.out.println("No shake.");
                break;
            }

            sb = sb.replace(leftIndex, leftIndex + pattern.length(), "");
            sb = sb.replace(rightIndex - pattern.length(), rightIndex, "");
            int index = pattern.length() / 2;
            pattern = pattern.substring(0, index) + pattern.substring(index + 1);
            System.out.println("Shaked it.");
        }

        System.out.println(sb);
    }
}
