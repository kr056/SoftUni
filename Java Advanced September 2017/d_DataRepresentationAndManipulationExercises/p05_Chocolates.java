package d_DataRepresentationAndManipulationExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p05_Chocolates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pickCount = Integer.parseInt(scan.nextLine());

        Arrays.sort(numbers);

        int bestMinDiff = getMinDifference(numbers, pickCount);

        System.out.printf("Min Difference is %d.", bestMinDiff);
    }

    private static int getMinDifference(int[] numbers, int pickCount) {
        List<Integer> current = new ArrayList<>();

        int bestMinDiff = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length + 1 - pickCount; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (current.size() == pickCount) {
                    break;
                }

                current.add(numbers[j]);
            }

            int currentMinDiff = current.get(current.size() - 1) - current.get(0);

            if (currentMinDiff <= bestMinDiff) {
                bestMinDiff = currentMinDiff;
            }

            current.clear();
        }

        return bestMinDiff;
    }

}