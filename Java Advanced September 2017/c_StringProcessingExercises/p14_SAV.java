package c_StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14_SAV {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String keysString = scan.nextLine();

        Pattern pattern = Pattern.compile("(^[a-zA-Z_]+(?=\\d)).*((?<=\\d)[a-zA-Z_]+$)");
        Matcher matcher = pattern.matcher(keysString);

        String startKey = "";
        String endKey = "";

        String text = scan.nextLine();

        if (matcher.find()) {
            startKey = matcher.group(1);
            endKey = matcher.group(2);
        } else {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern pattern1 = Pattern.compile(startKey + "([0-9.]*)" + endKey);
        Matcher matcher1 = pattern1.matcher(text);

        double sum = 0;

        while (matcher1.find()) {
            sum += Double.parseDouble(matcher1.group(1));
        }

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else if (sum % 1 == 0) {
            System.out.printf("<p>The total value is: <em>%d</em></p>", (int) sum);
        } else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }
    }
}
