package f_FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class p02_SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(", ");


        List<String> nums = new ArrayList<>();

        for (String anArr : arr) {
            nums.add(anArr);
        }

        Function<String, Integer> parser = Integer::parseInt;
        int sum = 0;

        for (String str : nums) {
            sum += parser.apply(str);
        }

        System.out.println("Count = " + nums.size());
        System.out.println("Sum = " + sum);
    }
}
