import java.util.Scanner;

public class p04_VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char symbol = input.charAt(0);

        if (Character.isDigit(symbol)) {
            System.out.println("digit");
        } else if (isVowel(symbol)) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }

    private static boolean isVowel(Character symbol) {

        char[] arr = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
        for (int i = 0; i < arr.length; i++) {
            if (symbol.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

}
