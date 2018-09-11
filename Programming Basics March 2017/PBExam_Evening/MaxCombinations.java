package PBExam_Evening;

import java.util.Scanner;

public class MaxCombinations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int beginningOfInterval = Integer.parseInt(console.nextLine());
        int endOfInterval = Integer.parseInt(console.nextLine());
        int max = Integer.parseInt(console.nextLine());
        int counter = 0;


        for (int i = beginningOfInterval; i <= endOfInterval; i++) {
            for (int j = beginningOfInterval; j <= endOfInterval; j++) {
                counter++;
                if (counter > max) {
                    break;
                }
                System.out.printf("<%d-%d>", i, j);

            }
        }
    }
}
