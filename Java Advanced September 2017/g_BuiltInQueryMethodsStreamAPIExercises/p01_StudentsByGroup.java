package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.*;

public class p01_StudentsByGroup {
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
                .filter(a -> a.contains("2"))
                .sorted((a, b) -> a.substring(0, a.indexOf(' ')).compareTo(b.substring(0, a.indexOf(' '))))
                .forEach(s -> System.out.println(s.replace("2", "")));

    }
}
