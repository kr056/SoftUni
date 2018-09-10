import java.util.Scanner;

public class p05_SquareFrame {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        System.out.println("+" + newString(" -", n - 2) + " +");

        for (int i = 0; i < n - 2; i++) {
            System.out.println("|" + newString(" -", n - 2) + " |");
        }

        System.out.println("+" + newString(" -", n - 2) + " +");


    }

    private static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }

}
