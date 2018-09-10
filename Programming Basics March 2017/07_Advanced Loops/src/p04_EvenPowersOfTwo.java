import java.util.Scanner;

public class p04_EvenPowersOfTwo {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int num = 1;

        System.out.println(num);

        for (int i = 0; i < n - 1; i += 2) {
            num *= 4;
            System.out.println(num);
        }

    }
}
