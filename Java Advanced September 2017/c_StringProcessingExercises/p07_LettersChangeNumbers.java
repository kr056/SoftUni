package c_StringProcessingExercises;

import java.util.Scanner;

public class p07_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split("\\s+");

        double totalSum = 0;

        for (int i = 0; i < words.length; i++) {
            double wordSum = 0;
            double number = Integer.parseInt(words[i].substring(1, words[i].length() - 1));

            char firstLetter = words[i].charAt(0);
            int alphabetPosFirstLetter = firstLetter % 32;

            if (Character.isLowerCase(firstLetter)) {
                wordSum += number * alphabetPosFirstLetter;
            } else if (Character.isUpperCase(firstLetter)) {
                wordSum += number / alphabetPosFirstLetter;
            }

            char lastLetter = words[i].charAt(words[i].length() - 1);
            int alphabetPosLastLetter = lastLetter % 32;

            if (Character.isLowerCase(lastLetter)) {
                wordSum += alphabetPosLastLetter;
            } else if (Character.isUpperCase(lastLetter)) {
                wordSum -= alphabetPosLastLetter;
            }
            totalSum += wordSum;
        }

        System.out.printf("%.2f", totalSum);
    }
}
