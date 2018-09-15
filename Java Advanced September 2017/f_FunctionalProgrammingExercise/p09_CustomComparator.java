package f_FunctionalProgrammingExercise;

import java.util.*;

public class p09_CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> nums = new ArrayList<>();

        for (int anArr : arr) {
            nums.add(anArr);
        }

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                if (Math.abs(num1) % 2 == 0 && Math.abs(num2) % 2 == 1) {
                    return -1;
                } else if (Math.abs(num2) % 2 == 0 && Math.abs(num1) % 2 == 1) {
                    return 1;
                } else {
                    return num1.compareTo(num2);
                }
            }
        };

        nums.sort(comp);

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
