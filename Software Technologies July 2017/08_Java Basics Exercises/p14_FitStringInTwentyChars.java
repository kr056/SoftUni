import java.util.Scanner;

public class p14_FitStringInTwentyChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        if (str.length() > 20) {
            String result = str.substring(0, 20);
            System.out.println(result);
        } else {
            int count = 20 - str.length();
            str += newString("*", count);
            System.out.println(str);
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
