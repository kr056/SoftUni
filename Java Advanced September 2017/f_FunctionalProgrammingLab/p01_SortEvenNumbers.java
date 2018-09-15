package f_FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            nums.add(arr[i]);
        }

        nums.removeIf(x -> x % 2 == 1);
        System.out.println(nums.toString().replaceAll("[]\\[]", ""));

        nums.sort(Integer::compareTo);
        System.out.println(nums.toString().replaceAll("[]\\[]", ""));
    }
}
