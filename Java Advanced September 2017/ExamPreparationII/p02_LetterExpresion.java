package ExamPreparationII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p02_LetterExpresion {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String pat = "[-]?\\d+";

        String input = bf.readLine();

        ArrayDeque<String> operations = new ArrayDeque<>(Arrays.stream(input.split(pat)).filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));


        ArrayDeque<Double> nums = new ArrayDeque<>();

        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            nums.add(Double.parseDouble(matcher.group()));
        }

        double result = nums.pop();

        while (!nums.isEmpty()) {
            if (operations.peek().length() % 2 == 0) {
                result += nums.pop();
            } else {
                result -= nums.pop();
            }
            operations.pop();
        }

        int output = (int) result;

        System.out.println(output);

    }
}
