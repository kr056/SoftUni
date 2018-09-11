package PBExam19March2017Evening;

import java.util.Scanner;

public class ControlNumber {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int m = Integer.parseInt(console.nextLine());
        int controlNumber = Integer.parseInt(console.nextLine());
        int sum = 0;
        int moves = 0;

        outerloop:
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                sum += (i * 2) + (j * 3);
                moves++;
                if (sum >= controlNumber) {
                    System.out.printf("%d moves%n", moves);
                    System.out.printf("Score: %d >= %d", sum, controlNumber);
                    break outerloop;
                }

            }
        }

        if (sum < controlNumber) {
            System.out.printf("%d moves", moves);

        }

    }
}
