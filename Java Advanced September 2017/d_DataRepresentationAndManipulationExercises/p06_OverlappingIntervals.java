package d_DataRepresentationAndManipulationExercises;

import java.util.Scanner;

public class p06_OverlappingIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int intervalsCount = Integer.parseInt(scan.nextLine());

        int[][] intervals = new int[intervalsCount][2];

        boolean thereIsOverlap = false;

        for (int i = 0; i < intervalsCount; i++) {
            String[] input = scan.nextLine().split(",");

            for (int j = 0; j < 2; j++) {
                intervals[i][j] = Integer.parseInt(input[j]);
            }
        }

        outerloop:
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] < intervals[j][1]) {
                    thereIsOverlap = true;
                    break outerloop;
                }
            }
        }

        printTheResult(thereIsOverlap);
    }

    private static void printTheResult(boolean thereIsOverlap) {
        if (thereIsOverlap) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
