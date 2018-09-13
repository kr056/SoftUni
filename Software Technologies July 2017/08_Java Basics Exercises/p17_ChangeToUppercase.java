import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p17_ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String pat = "(<upcase>)(.+?)(<\\/upcase>)";

        String replaceStr = "";

        Pattern pattern = Pattern.compile(pat);

        Matcher match = pattern.matcher(input);

        while (match.find()) {
            replaceStr = match.group(2).toUpperCase();
            input = input.replaceFirst(pat, replaceStr);
        }

        System.out.println(input);

    }
}
