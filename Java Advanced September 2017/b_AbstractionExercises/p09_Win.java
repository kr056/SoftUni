package b_AbstractionExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class p09_Win {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\|.*?\\|");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int sum = 0;

            for (int i = 1; i < matcher.group().length() - 1; i++) {
                sum += matcher.group().charAt(i);
            }

            int bombPower = sum % 10;
            int startIndex = Math.max(0, input.indexOf(matcher.group()) - bombPower);
            int endIndex = Math.min(input.length(), input.indexOf(matcher.group()) + bombPower + matcher.group().length());
            String strToReplace = input.substring(startIndex, endIndex);
            input = input.replace(strToReplace, newString(".", strToReplace.length()));
        }

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
