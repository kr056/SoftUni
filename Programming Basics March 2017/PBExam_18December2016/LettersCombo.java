package PBExam_18December2016;

import java.util.Scanner;

public class LettersCombo {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        char startofInterval = console.next().charAt(0);
        char endofInterval = console.next().charAt(0);
        char left = console.next().charAt(0);
        int counter = 0;

        for (int i = (char) startofInterval; i <= (char) endofInterval; i++) {
            for (int j = (char) startofInterval; j <= (char) endofInterval; j++) {
                for (int k = (char) startofInterval; k <= (char) endofInterval; k++) {


                    if (i == left || j == left || k == left) {

                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append((char) i);
                        sb.append((char) j);
                        sb.append((char) k);
                        sb.append(" ");

                        System.out.printf(sb.toString());

                        counter++;
                    }
                }
            }
        }

        System.out.print(counter);

    }
}
