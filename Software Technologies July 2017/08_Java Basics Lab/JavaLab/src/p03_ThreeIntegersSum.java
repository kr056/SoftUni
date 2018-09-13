import java.util.Scanner;

public class p03_ThreeIntegersSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        int[] nums = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        int num1 = nums[0];
        int num2 = nums[1];
        int num3 = nums[2];

        if (!checkNums(num1, num2, num3)
                && !checkNums(num1, num3, num2)
                && !checkNums(num2, num3, num1)) {
            System.out.println("No");
        }
    }

    private static boolean checkNums(int num1, int num2, int num3) {
        if (num1 + num2 != num3) {
            return false;
        }

        int small = Math.min(num1, num2);
        int bigger = Math.max(num1, num2);

        System.out.printf("%d + %d = %d", small, bigger, num3);

        return true;
    }
}
