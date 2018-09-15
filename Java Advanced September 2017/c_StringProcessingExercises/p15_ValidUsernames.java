package c_StringProcessingExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p15_ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("[/\\s\\\\()]+");

        List<String> validNames = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w]{2,24}\\b");
        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            while (matcher.find()) {
                validNames.add(input[i]);
            }
        }

        int bestLength = 0;
        int firstBestIndex = 0;
        int lastBestIndex = 0;

        for (int i = 0; i < validNames.size() - 1; i++) {
            int currentLength = validNames.get(i).length() + validNames.get(i + 1).length();

            if (currentLength > bestLength) {
                bestLength = currentLength;
                firstBestIndex = i;
                lastBestIndex = i + 1;
            }
        }

        System.out.println(validNames.get(firstBestIndex));
        System.out.println(validNames.get(lastBestIndex));
    }
}
