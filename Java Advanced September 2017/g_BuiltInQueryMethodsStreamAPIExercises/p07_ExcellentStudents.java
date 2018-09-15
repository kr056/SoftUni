package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p07_ExcellentStudents {
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
                .filter(a -> a.contains("6"))
                .forEach(s -> System.out.println(s.replaceAll("\\d+", "")));
    }
}
