package g_BuiltInQueryMethodsStreamAPIExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p04_SortStudents {
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
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String lastName1 = o1.substring(o1.lastIndexOf(" ") + 1);
                        String lastName2 = o2.substring(o2.lastIndexOf(" ") + 1);

                        String firstName1 = o1.substring(0, o1.indexOf(" "));
                        String firstName2 = o2.substring(0, o2.indexOf(" "));

                        int compOne = lastName1.compareTo(lastName2);

                        if (compOne != 0) {
                            return compOne;
                        } else {
                            return firstName2.compareTo(firstName1);
                        }
                    }
                })
                .forEach(System.out::println);
    }
}
