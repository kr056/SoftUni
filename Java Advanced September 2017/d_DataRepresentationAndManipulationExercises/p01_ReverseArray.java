package d_DataRepresentationAndManipulationExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p01_ReverseArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        reverse(nums, nums.length - 1);

    }

    private static void reverse(int[] nums, int index) {
        if (index == 0) {
            System.out.println(nums[index]);
            return;
        }

        System.out.print(nums[index] + " ");

        reverse(nums, index - 1);
    }
}
