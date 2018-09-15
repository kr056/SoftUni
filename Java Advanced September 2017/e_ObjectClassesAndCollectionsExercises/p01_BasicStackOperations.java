package e_ObjectClassesAndCollectionsExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] lineOne = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPushCount = lineOne[0];
        int elementsToPopCount = lineOne[1];
        int checkNumber = lineOne[2];

        int[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPushCount; i++) {
            stack.push(nums[i]);
        }

        for (int i = 0; i < elementsToPopCount; i++) {
            stack.pop();
        }

        if (stack.contains(checkNumber)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(getMin(stack));
        }
    }

    private static int getMin(ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;

        for (int num : stack) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
}
