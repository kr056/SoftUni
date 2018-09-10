import java.util.Scanner;

public class p06_RhombusOfStars {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int height = n * 2 - 1;
        int maxwid = n * 2 - 1;

        //upper part
        for (int i = 0; i < n; i++) {
            String spaces = newString(" ", (n - 1) - i);
            System.out.println(spaces + "*" + newString(" *", i));
        }
        //other

        for (int i = n - 1; i > 0; i--) {
            String spaces = newString(" ", (n - i));
            System.out.println(spaces + "*" + newString(" *", i - 1));
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
