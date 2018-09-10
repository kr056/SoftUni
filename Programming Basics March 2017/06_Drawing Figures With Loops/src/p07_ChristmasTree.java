import java.util.Scanner;

public class p07_ChristmasTree {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i <= n; i++) {
            String spaces = newString(" ", n - i);
            String a = newString("*", i);
            System.out.println(spaces + a + " | " + a);
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
