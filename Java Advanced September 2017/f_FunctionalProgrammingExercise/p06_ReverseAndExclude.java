package f_FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p06_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();

        String[] line = scan.nextLine().split("\\s+");

        int key = Integer.parseInt(scan.nextLine());

        for (int i = line.length - 1; i >= 0; i--) {
            nums.add(Integer.parseInt(line[i]));
        }

        nums.removeIf(x -> x % key == 0);

        System.out.println(nums.toString().replaceAll("[]\\[,]", ""));

    }
}
