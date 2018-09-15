package c_StringProcessingExercises;

import java.util.Scanner;


public class p06_MagicExchangableWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split(" ");
        String word1 = words[0];
        String word2 = words[1];

        String distinctedWordOne = distinct(word1);
        String distinctedWordTwo = distinct(word2);

        boolean areMagic = true;

        if (distinctedWordOne.length() != distinctedWordTwo.length()) {
            areMagic = false;
        }

        if (areMagic) {
            System.out.println("true");
        } else {
            System.out.println(false);
        }

    }

    private static String distinct(String word1) {
        String result = "";

        for (int i = 0; i < word1.length(); i++) {
            if (!result.contains(Character.toString(word1.charAt(i)))) {
                result += word1.charAt(i);
            }
        }

        return result;
    }
}
