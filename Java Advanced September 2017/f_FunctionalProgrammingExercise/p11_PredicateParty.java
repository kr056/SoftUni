package f_FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.BiPredicate;

public class p11_PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] names = scan.nextLine().split("\\s+");

        List<String> guests = new ArrayList<>();
        Collections.addAll(guests, names);

        BiPredicate<String, String> startTest = (String::startsWith);

        BiPredicate<String, String> endTest = (String::endsWith);

        BiPredicate<String, Integer> lengthTest = ((a, b) -> a.length() == b);

        List<String> toAdd = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Party!")) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            String type = tokens[1];
            String condition = tokens[2];

            switch (type) {
                case "StartsWith":
                    if (cmd.equals("Remove")) {
                        guests.removeIf(x -> x.startsWith(condition));
                    } else {
                        for (String guest : guests) {
                            if (startTest.test(guest, condition)) {
                                toAdd.add(guest);
                            }
                        }

                        guests.addAll(toAdd);
                        toAdd.clear();
                    }
                    break;
                case "EndsWith":
                    if (cmd.equals("Remove")) {
                        guests.removeIf(y -> y.endsWith(condition));
                    } else {
                        for (String guest : guests) {
                            if (endTest.test(guest, condition)) {
                                toAdd.add(guest);
                            }
                        }

                        guests.addAll(toAdd);
                        toAdd.clear();
                    }
                    break;
                case "Length":
                    if (cmd.equals("Remove")) {
                        guests.removeIf(z -> z.length() == Integer.parseInt(condition));
                    } else {
                        for (String guest : guests) {
                            if (lengthTest.test(guest, Integer.parseInt(condition))) {
                                toAdd.add(guest);
                            }
                        }

                        guests.addAll(toAdd);
                        toAdd.clear();
                    }
                    break;
            }
        }

        if (guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(guests.toString().replaceAll("[]\\[]", ""));
            System.out.println(" are going to the party!");
        }
    }
}
