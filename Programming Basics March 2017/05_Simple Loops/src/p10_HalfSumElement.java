import java.util.Scanner;

public class p10_HalfSumElement {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(console.nextLine());
            if (num > max) {
                max = num;
            }

            sum += num;

        }
        sum = sum - max;
        int diff = Math.abs(max - sum);
        if (diff != 0) {
            System.out.printf("No Diff  = %d", diff);
        } else {
            System.out.printf("Yes Sum = %d", max);
        }
    }
}