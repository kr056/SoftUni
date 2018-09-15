package c_StringProcessingLab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String pat = "(<upcase>)(.+?)(<\\/upcase>)";

        String replaceStr = "";

        ArrayList<String> allMatches = new ArrayList<String>();

        Pattern pattern = Pattern.compile(pat);

        Matcher match = pattern.matcher(input);
        while (match.find()) {
            allMatches.add(match.group(2).toUpperCase());
        }

        for (int i = 0; i < allMatches.size(); i++) {
            input = input.replaceFirst(pat, allMatches.get(i));
        }

        System.out.println(input);
    }
}
