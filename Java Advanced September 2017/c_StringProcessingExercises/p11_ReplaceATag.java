package c_StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "<a href=\\\".+\\\">([\\s\\S]+?<\\/a>)?";
        String text = "";

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            text += input + "\n";

        }

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String replacement = matcher.group().replace("<a", "[URL").replace("</a>", "[/URL]").replace(">", "]");
            text = text.replace(matcher.group(), replacement);
        }

        System.out.println(text);
    }

}
