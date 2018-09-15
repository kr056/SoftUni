package c_StringProcessingExercises;

import java.util.Scanner;

public class p01_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        String toSearch = scanner.nextLine().toLowerCase();

        int counter = 0;

        while (input.contains(toSearch)) {
            counter++;
            input = input.substring(input.indexOf(toSearch) + 1);
        }

        System.out.println(counter);
    }
}
