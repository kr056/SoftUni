package PBExam_18March2017;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int beginningofInterval = Integer.parseInt(console.nextLine());
        int endofInterval = Integer.parseInt(console.nextLine());
        int magicNumber = Integer.parseInt(console.nextLine());

        int counter = 0;
        int tr = 0;

        outerloop:
        for (int i = beginningofInterval; i <= endofInterval; i++) {
            for (int j = beginningofInterval; j <= endofInterval; j++) {
                counter++;
                if (i + j == magicNumber) {
                    tr = i + j;
                    System.out.printf("Combination N:%d ", counter);
                    System.out.printf("(%d + %d = %d)", i, j, magicNumber);
                    break outerloop;
                }

            }
        }

        if (tr != magicNumber) {
            System.out.printf("%d combinations - ", counter);
            System.out.printf("neither equals ");
            System.out.printf("%d", magicNumber);
        }

    }
}
