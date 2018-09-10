import java.util.Scanner;

public class p08_Factorial {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        if (n == 0) {
            System.out.println(1);
        } else {
            for (int i = n - 1; i > 0; i--) {
                n = n * i;
            }

            System.out.println(n);
        }
    }
}
