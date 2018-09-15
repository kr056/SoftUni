package f_FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class p13_InfernoIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        HashMap<String, Predicate<Integer>> commands = new HashMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Forge")) {
                break;
            }

            String[] tokens = input.split(";");
            Predicate<Integer> predicate = makePredicate(tokens, arr);

            if ("Exclude".equals(tokens[0])) {
                commands.put(tokens[1] + tokens[2], predicate);
            } else {
                commands.remove(tokens[1] + tokens[2]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            boolean forRemove = false;

            for (Predicate<Integer> predicate : commands.values()) {
                if (predicate.test(i)) {
                    forRemove = true;
                    break;
                }
            }

            if (!forRemove) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    private static Predicate<Integer> makePredicate(String[] tokens, int[] arr) {
        String operation = tokens[1];
        int condition = Integer.parseInt(tokens[2]);

        switch (operation) {
            case "Sum Left":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] == condition;
            case "Sum Right":
                return index -> arr[index] + (index < arr.length - 1 ? arr[index + 1] : 0) == condition;
            default:
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index]
                        + (index < arr.length - 1 ? arr[index + 1] : 0) == condition;

        }
    }
}
