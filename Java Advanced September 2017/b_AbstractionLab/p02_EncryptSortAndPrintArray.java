package b_AbstractionLab;

import java.util.Arrays;
import java.util.Scanner;

public class p02_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringCount = Integer.parseInt(scanner.nextLine());

        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        int[] results = new int[stringCount];

        for (int i = 0; i < stringCount; i++) {

            String str = scanner.nextLine();
            int strSum = 0;

            for (int j = 0; j < str.length(); j++) {
                char currentChar = str.charAt(j);
                if (vowelOrNot(str, vowels, currentChar)) {
                    strSum += currentChar * str.length();
                } else {
                    strSum += currentChar / str.length();
                }
            }
            results[i] = strSum;
        }

        Arrays.sort(results);
        for (int strSum : results) {
            System.out.println(strSum);
        }
    }

    private static boolean vowelOrNot(String str, char[] vowels, char currentChar) {
        for (int i = 0; i < vowels.length; i++) {
            if (Character.toString(currentChar).equals(Character.toString(vowels[i]))) {
                return true;
            }
        }

        return false;
    }
}
