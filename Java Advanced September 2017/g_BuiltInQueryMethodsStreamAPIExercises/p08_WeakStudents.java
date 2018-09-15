package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p08_WeakStudents {
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
                .filter(a -> getGrades(a))
                .forEach(s -> System.out.println(s.replaceAll("\\d+", "")));
    }

    private static boolean getGrades(String a) {

        List<Integer> grades = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(a);

        while (matcher.find()) {
            int grade = Integer.parseInt(matcher.group());

            if (grade <= 3) {
                grades.add(grade);
            }
        }

        return grades.size() >= 2;
    }
}
