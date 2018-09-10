import java.util.Scanner;

public class p07_LeftAndRightSum {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            int left = Integer.parseInt(console.nextLine());
            leftSum += left;
        }
        for (int i = 0; i < n; i++) {
            int right = Integer.parseInt(console.nextLine());
            rightSum += right;
        }

        int diff = Math.abs(leftSum - rightSum);

        if (diff != 0) {
            System.out.printf("No, diff = %d", diff);
        } else {
            System.out.printf("Yes, sum = %d", leftSum);
        }

    }
}
