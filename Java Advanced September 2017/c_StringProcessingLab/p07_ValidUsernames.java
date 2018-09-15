package c_StringProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> str = new ArrayList<>();

        int validCounter = 0;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            Pattern pattern = Pattern.compile("^[a-zA-Z0-9-_]{3,16}$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                str.add("valid");
                validCounter++;
            } else {
                str.add("invalid");
            }
        }

        if (validCounter > 0) {
            for (String output : str) {
                System.out.println(output);
            }
        }
    }
}
