package f_FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class p10_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int range = Integer.parseInt(scan.nextLine());

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<Integer, Integer> tester = ((a, b) -> a % b == 0);

        for (int i = 1; i <= range; i++) {
            boolean isDivisibleByAll = true;
            for (int num : arr) {
                if (!tester.test(i, num)) {
                    isDivisibleByAll = false;
                    break;
                }
            }

            if (isDivisibleByAll) {
                System.out.print(i + " ");
            }
        }

    }


}
