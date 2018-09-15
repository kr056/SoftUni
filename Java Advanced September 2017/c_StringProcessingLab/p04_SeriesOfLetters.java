package c_StringProcessingLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(Character.toString(matcher.group(1).charAt(0)));
        }

        System.out.println();
    }
}
