package f_FunctionalProgrammingExercise;

import java.util.Scanner;
import java.util.function.Function;


public class p03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nums = scan.nextLine().split("\\s+");

        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        Function<Integer[], Integer> findMin = x -> getMin(x);

        System.out.println(findMin.apply(arr));

    }

    private static Integer getMin(Integer[] x) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }

        return min;
    }


}
