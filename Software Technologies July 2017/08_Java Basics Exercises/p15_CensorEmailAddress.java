import java.util.Scanner;

public class p15_CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String input = scanner.nextLine();

        String[] tokens = email.split("@");
        String username = tokens[0];
        String domain = tokens[1];

        String newEmail = newString("*", username.length()) + "@" + domain;

        input = input.replaceAll(email, newEmail);

        System.out.println(input);

    }

    private static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
