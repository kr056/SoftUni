package d_DataRepresentationAndManipulationExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p07_FindTheMissingNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nums);

        if (nums[0] != 1) {
            System.out.println(1);
            return;
        }

        boolean isFound = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (Math.abs(nums[i + 1] - nums[i]) != 1) {
                System.out.println(nums[i] + 1);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println(length);
        }
    }
}
