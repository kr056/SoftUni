import java.util.Scanner;

public class p09_House {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int stars = 1;
        if (n % 2 == 0) {
            stars++;
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            int padding = ((n - stars) / 2);
            System.out.print(newString("-", padding));
            System.out.print(newString("*", stars));
            System.out.println(newString("-", padding));
            stars += 2;
        }
        for (int i = 0; i <= n / 2 - 1; i++) {
            System.out.println("|" + newString("*", n - 2) + "|");
        }

    }

    private static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
