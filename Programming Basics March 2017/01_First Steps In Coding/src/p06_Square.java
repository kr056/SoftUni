import java.util.Scanner;

public class p06_Square {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        for (int j = 0; j < n; j++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int j = 0; j < n; j++) {

            System.out.print("*");
        }
    }
}
