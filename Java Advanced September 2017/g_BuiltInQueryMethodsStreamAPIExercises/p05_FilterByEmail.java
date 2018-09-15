package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p05_FilterByEmail {
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
                .filter(a -> a.contains("@gmail.com"))
                .forEach(s -> System.out.println(s.substring(0, s.lastIndexOf(" "))));
    }
}
