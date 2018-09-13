import java.util.Arrays;
import java.util.Scanner;

public class p11_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int left = i; left >= 0; left--) {
                leftSum += numbers[left];
            }
            for (int right = i; right < numbers.length; right++) {
                rightSum += numbers[right];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");

    }
}

