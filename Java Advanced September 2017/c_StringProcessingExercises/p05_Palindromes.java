package c_StringProcessingExercises;

import java.util.*;

public class p05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[\\s+.,?!]+");

        Set<String> palindromes = new TreeSet<>();

        for (int i = 0; i < input.length; i++) {
            boolean isPalindrome = true;

            for (int j = 0; j < input[i].length() / 2; j++) {
                if (input[i].charAt(j) != input[i].charAt(input[i].length() - j - 1)) {
                    isPalindrome = false;
                }
            }

            if (isPalindrome) {
                palindromes.add(input[i]);
            }
        }

        System.out.println(palindromes);
    }
}
