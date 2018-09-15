package c_StringProcessingExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_SentenceExtractor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String keyWord = scan.nextLine();

        String[] input = scan.nextLine().split("\\s+");

        List<String> sentences = new ArrayList<>();
        String result = "";

        for (int i = 0; i < input.length; i++) {
            result += input[i] + " ";

            if (input[i].contains("!") || input[i].contains("?")
                    || input[i].contains(".")) {
                sentences.add(result);
                result = "";
            }
        }

        for (int i = 0; i < sentences.size(); i++) {
            Pattern pattern = Pattern.compile("\\b" + keyWord + "\\b");
            Matcher matcher = pattern.matcher(sentences.get(i));

            if (matcher.find()) {
                System.out.println(sentences.get(i));
            }
        }
    }
}