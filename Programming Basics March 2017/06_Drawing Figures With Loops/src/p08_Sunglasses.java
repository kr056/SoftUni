import java.util.Scanner;

public class p08_Sunglasses {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String spaces = newString(" ", n);

        System.out.println(newString("*", n * 2) + spaces + newString("*", n * 2));
        for (int i = 0; i < n - 2; i++) {

            if (i == (n - 1) / 2 - 1) {
                System.out.println("*" + newString("/", n * 2 - 2) + "*" + newString("|", n) + "*" + newString("/", n * 2 - 2) + "*");
            } else {
                System.out.println("*" + newString("/", n * 2 - 2) + "*" + spaces + "*" + newString("/", n * 2 - 2) + "*");

            }
        }

        System.out.println(newString("*", n * 2) + spaces + newString("*", n * 2));

    }

    private static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }

}
