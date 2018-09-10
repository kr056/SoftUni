import java.util.Scanner;

public class p04_TriangleOfDollars {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println(newString("$ ", i));
        }

        System.out.println();

    }

    private static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }

}
