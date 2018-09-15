package f_FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class p05_FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String name = input[0];

            int age = Integer.parseInt(input[1]);

            people.put(name, age);
        }

        String condition = scan.nextLine();
        int conditionAge = Integer.parseInt(scan.nextLine());
        String printFormat = scan.nextLine();

        Predicate<Integer> testOldOrYoung = createTester(condition, conditionAge);

        Consumer<Map.Entry<String, Integer>> printer = createPrinter(printFormat);

        printFilteredPeople(people, testOldOrYoung, printer);

    }

    private static void printFilteredPeople(LinkedHashMap<String, Integer> people,
                                            Predicate<Integer> testOldOrYoung,
                                            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (testOldOrYoung.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }

    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String printFormat) {
        switch (printFormat) {
            case "name age":
                return person -> System.out.printf("%s - %d\n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s\n", person.getKey());
            case "age":
                return person -> System.out.printf("%d\n", person.getValue());
            default:
                return null;
        }
    }

    private static Predicate<Integer> createTester(String condition, int conditionAge) {
        switch (condition) {
            case "older":
                return x -> x >= conditionAge;
            case "younger":
                return x -> x < conditionAge;
            default:
                return null;
        }
    }
}
