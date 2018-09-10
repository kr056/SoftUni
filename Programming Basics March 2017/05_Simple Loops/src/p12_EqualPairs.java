
import java.util.Scanner;

public class p12_EqualPairs {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int pairSum = 0;
        int maxDiff = 0;
        int lastSum = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(console.nextLine());
            int y = Integer.parseInt(console.nextLine());

            pairSum = x + y;
            if (i > 0) {
                int diff = Math.abs(pairSum - lastSum);

                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }

            lastSum = pairSum;

        }

        if (maxDiff == 0) {
            System.out.println("Yes , value = " + pairSum);
        } else {
            System.out.println("No , maxdiff = " + maxDiff);
        }

    }
}
