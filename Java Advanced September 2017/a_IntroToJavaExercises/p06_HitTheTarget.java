package a_IntroToJavaExercises;

import java.util.Scanner;

public class p06_HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 20; j > 0; j--) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d\n", i, j, target);
                } else if (i - j == target) {
                    System.out.printf("%d - %d = %d\n", i, j, target);
                }
            }
        }
    }
}
