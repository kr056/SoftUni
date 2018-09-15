package c_StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_Hyperlinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("<a\\s+([^>]+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)\"|([^>]*))[^>]*>");

        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }

            sb.append(input);
        }

        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            for (int i = 5; i >= 0; i--) {
                String result = matcher.group(i);

                if (result != null) {
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
