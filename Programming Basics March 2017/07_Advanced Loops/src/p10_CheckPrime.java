import java.util.Scanner;

public class p10_CheckPrime {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int counter = 2;

        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        }

        while (counter < n) {
            if (n % counter == 0) {
                isPrime = false;
                break;
            }
            counter++;
        }

        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}