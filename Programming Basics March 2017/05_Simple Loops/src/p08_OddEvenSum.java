import java.util.Scanner;

public class p08_OddEvenSum {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= n; i++) {

            if (i % 2 == 0) {
                int even = Integer.parseInt(console.nextLine());
                evenSum += even;
            } else {
                int odd = Integer.parseInt(console.nextLine());
                oddSum += odd;
            }
        }

        int diff = Math.abs(evenSum - oddSum);

        if (diff != 0) {
            System.out.printf("No, diff = %d", diff);
        } else {
            System.out.printf("Yes, sum = %d", evenSum);
        }

    }

}

