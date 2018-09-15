package d_DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Bang on 2.10.2017 г..
 */
public class p03_BinarySearchWithRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        int[] nums = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(bf.readLine());

        Arrays.sort(nums);

        System.out.println(binarySearch(nums, key, 0, nums.length));

    }

    private static int binarySearch(int[] nums, int key, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;

            if (mid >= nums.length) {
                return -1;
            }

            if (key < nums[mid]) {
                return binarySearch(nums, key, 0, mid);
            } else if (key > nums[mid]) {
                return binarySearch(nums, key, mid + 1, end);
            } else {
                return mid;
            }
        }

        return -1;
    }
}
