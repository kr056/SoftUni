package g_BuiltInQueryMethodsStreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p08_BoundedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        int lowerBound = Math.min(num1, num2);
        int upperBound = Math.max(num1, num2);

        List<String> nums = Arrays.asList(scanner.nextLine().split("\\s+"));

        nums.stream()
                .mapToInt(Integer::valueOf)
                .filter(a -> lowerBound <= a && a <= upperBound)
                .forEach(p -> System.out.print(p + " "));

    }
}
