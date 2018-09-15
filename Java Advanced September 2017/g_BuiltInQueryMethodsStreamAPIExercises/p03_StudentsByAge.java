package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p03_StudentsByAge {
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
                .filter(a -> ageFilter(a))
                .forEach(System.out::println);
    }

    private static boolean ageFilter(String a) {
        int age = Integer.parseInt(a.substring(a.lastIndexOf(" ") + 1));

        return age >= 18 && age <= 24;
    }
}
