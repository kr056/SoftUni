package f_FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class p12_ThePartyReservationFilterMode {

    private static Predicate<String> currentPredicate;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] names = scan.nextLine().split("\\s+");

        List<String> guests = new ArrayList<>();
        Collections.addAll(guests, names);

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Print")) {
                break;
            }

            String[] tokens = input.split(";");
            String filterType = tokens[1];
            String filter = tokens[0];
            String condition = tokens[2];

            Predicate<String> startTest = s -> s.startsWith(condition);
            Predicate<String> endTest = s -> s.endsWith(condition);
            Predicate<String> containsTest = s -> s.contains(condition);
            Predicate<String> lengthTest = s -> s.length() == Integer.parseInt(condition);

            switch (filterType) {
                case "Starts with":
                    currentPredicate = startTest;
                    break;
                case "Ends with":
                    currentPredicate = endTest;
                    break;
                case "Length":
                    currentPredicate = lengthTest;
                    break;
                case "Contains":
                    currentPredicate = containsTest;
                    break;
            }

            if (filter.equals("Add filter")) {
                guests.removeIf(currentPredicate);
            } else {
                for (String str : names) {
                    if (currentPredicate.test(str)) {
                        guests.add(str);
                    }
                }
            }

        }
        System.out.println(guests.toString().replaceAll("[]\\[,]", ""));
    }
}
