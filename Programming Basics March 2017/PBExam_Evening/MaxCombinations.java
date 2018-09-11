package PBExam_Evening;

import java.util.Scanner;

public class MaxCombinations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int beginningofInterval = Integer.parseInt(console.nextLine());
        int endofInterval = Integer.parseInt(console.nextLine());
        int max = Integer.parseInt(console.nextLine());
        int counter =0;

      //  StringBuilder stringBuilder = new StringBuilder();


        for (int i = beginningofInterval; i <= endofInterval; i++) {
            for (int j = beginningofInterval; j <= endofInterval; j++) {
                counter++;
                if(counter>max){
                    break;
                }
                System.out.printf("<%d-%d>",i,j);

            }
        }
    }
}
