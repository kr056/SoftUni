package e_ObjectClassesAndCollectionsExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p03_BasicQueueOperations {
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

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToPushCount; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < elementsToPopCount; i++) {
            queue.poll();
        }

        if (queue.contains(checkNumber)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(getMin(queue));
        }
    }

    private static int getMin(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;

        for (int num : queue) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
}
