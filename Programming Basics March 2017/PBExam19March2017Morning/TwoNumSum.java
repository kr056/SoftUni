package PBExam19March2017Morning;

import java.util.Scanner;

public class TwoNumSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int endofInterval = Integer.parseInt(console.nextLine());
        int beginningofInterval = Integer.parseInt(console.nextLine());

        int magicNumber = Integer.parseInt(console.nextLine());


        int counter = 0;
        int tr = 0;
        outerloop:
        for (int i =endofInterval; i >= beginningofInterval; i--) {
            for (int j = endofInterval; j >= beginningofInterval; j--) {
                counter++;
                if (i + j == magicNumber) {
                    tr=i+j;
                    System.out.printf("Combination N:%d ", counter);
                    System.out.printf("(%d + %d = %d)", i, j, magicNumber);
                    break outerloop;
                }

            }
        }

        if(tr!=magicNumber){
            System.out.printf("%d combinations - ",counter);
            System.out.printf("neither equals ");
            System.out.printf("%d",magicNumber);
        }

    }
}
