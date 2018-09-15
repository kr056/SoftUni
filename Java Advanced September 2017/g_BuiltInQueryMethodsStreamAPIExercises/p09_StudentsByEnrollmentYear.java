package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_StudentsByEnrollmentYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> students = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if ("END".equals(input)) {
                break;
            }
            students.add(input);
        }

        students.stream()
                .filter(a -> getEnrolledInSpecYear(a))
                .forEach(s -> System.out.println(s.replaceAll("\\d{2,}", "")));
    }

    private static boolean getEnrolledInSpecYear(String a) {

        Pattern pattern = Pattern.compile("\\d{2,}");
        Matcher matcher = pattern.matcher(a);

        int year = 0;

        if (matcher.find()) {
            String result = matcher.group();
            year = Integer.parseInt(result.substring(4));
        }

        return year == 14 || year == 15;
    }
}
