package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p02_StudentsByFirstAndLastName {
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
                .filter(a -> filterLex(a))
                .forEach(System.out::println);
    }

    private static boolean filterLex(String a) {
        String firstName = a.substring(0, a.indexOf(" "));
        String lastName = a.substring(a.indexOf(" ") + 1);

        if (firstName.compareTo(lastName) < 0) {
            return true;
        } else {
            return false;
        }
    }
}
