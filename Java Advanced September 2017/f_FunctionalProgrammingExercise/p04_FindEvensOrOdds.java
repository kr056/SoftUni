package f_FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p04_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();

        String[] line = scan.nextLine().split("\\s+");

        String type = scan.nextLine();

        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        for (int i = Math.min(start, end); i <= Math.max(start, end); i++) {
            nums.add(i);
        }

        if (type.equals("odd")) {
            nums.removeIf(x -> x % 2 == 0);
        } else {
            nums.removeIf(y -> y % 2 == 1);
        }

        System.out.println(nums.toString().replaceAll("[]\\[,]", ""));
    }
}
