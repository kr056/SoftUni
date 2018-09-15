package c_StringProcessingLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[aeoiuyAEOUIY]");
        Matcher matcher = pattern.matcher(input);

        int vowelsCount = 0;

        while (matcher.find()) {
            vowelsCount++;
        }

        System.out.println("Vowels: " + vowelsCount);
    }
}
