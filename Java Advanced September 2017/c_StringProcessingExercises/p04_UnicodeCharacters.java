package c_StringProcessingExercises;

import java.util.Scanner;

public class p04_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.print("\\u00" + Integer.toHexString(input.charAt(i)));
        }
    }
}
